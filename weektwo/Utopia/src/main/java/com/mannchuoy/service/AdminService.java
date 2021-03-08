/**
 * 
 */
package com.mannchuoy.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.mannchuoy.dao.AirportDao;
import com.mannchuoy.dao.DBConnection;
import com.mannchuoy.dao.FlightDao;
import com.mannchuoy.dao.RouteDao;
import com.mannchuoy.entity.Airport;
import com.mannchuoy.entity.Flight;
import com.mannchuoy.entity.Route;

/**
 * @author Mannchuoy Yam
 *
 */
public class AdminService {

	public void addAirport(Airport airport) throws SQLException {
		Connection connection = null;
		try {
			connection = DBConnection.getConnection(Boolean.FALSE);
			AirportDao airportDao = new AirportDao(connection);
			airportDao.addAirport(airport);

			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			connection.rollback();
		} finally {
			connection.close();
		}
	}

	public void updateAirport(Airport airport) throws SQLException {
		Connection connection = null;
		try {
			connection = DBConnection.getConnection(Boolean.FALSE);
			AirportDao airportDao = new AirportDao(connection);
			airportDao.updateAirport(airport);

			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			connection.rollback();
		} finally {
			connection.close();
		}
	}

	public void deleteAirport(Airport airport) throws SQLException {
		Connection connection = null;
		try {
			connection = DBConnection.getConnection(Boolean.FALSE);
			AirportDao airportDao = new AirportDao(connection);
			airportDao.deleteAirport(airport);

			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			connection.rollback();
		} finally {
			connection.close();
		}
	}

	public List<Airport> listAirports() throws SQLException {
		Connection connection = null;
		List<Airport> airports = null;
		try {
			connection = DBConnection.getConnection(Boolean.FALSE);
			AirportDao airportDao = new AirportDao(connection);
			airports = airportDao.listAirport();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			connection.rollback();
		} finally {
			connection.close();
		}

		return airports;
	}

	private int getFlightRouteId(Airport origin, Airport destination, Flight flight, Connection connection) throws SQLException {
		// check if origin and destination exist
		AirportDao airportDao = new AirportDao(connection);

		List<Airport> airports = airportDao.read("SELECT * FROM airport WHERE iata_id = ?",
				new Object[] { origin.getId() });
		if (airports.size() == 0) {
			airportDao.addAirport(origin);
		}
		airports = airportDao.read("SELECT * FROM airport WHERE iata_id = ?", new Object[] { destination.getId() });
		if (airports.size() == 0) {
			airportDao.addAirport(destination);
		}

		RouteDao routeDao = new RouteDao(connection);
		List<Route> routes = routeDao.read("SELECT * FROM route WHERE origin_id = ? AND destination_id = ?",
				new Object[] { origin.getId(), destination.getId() });
		
		
		if (routes.size() == 0) {
			Route route = new Route();
			route.setOriginId(origin.getId());
			route.setDestinationId(destination.getId());
			
			return routeDao.addRouteAndGetPrimaryKey(route);
		} else {
			return routes.get(0).getId();
		}
	}

	// Flight service
	public void addFlight(Airport origin, Airport destination, Flight flight) throws SQLException {
		Connection connection = null;
		try {
			connection = DBConnection.getConnection(Boolean.FALSE);
			
			int routeId = getFlightRouteId(origin, destination, flight, connection);
			
			flight.setRouteId(routeId);

			FlightDao flightDao = new FlightDao(connection);
			flightDao.addFlight(flight);

			connection.commit();
			if(flightDao.findFlightById(flight.getId()) != null) {
				System.out.println("Flight id: " + flight.getId() + " has been added.\n");
			}
			
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	public void updateFlight(Airport origin, Airport destination, Flight flight) throws SQLException {
		Connection connection = null;
		try {
			connection = DBConnection.getConnection(Boolean.FALSE);
			
			int routeId = getFlightRouteId(origin, destination, flight, connection);
			
			flight.setRouteId(routeId);
			
			FlightDao flightDao = new FlightDao(connection);
			int affectedRows = flightDao.updateFlight(flight);

			connection.commit();
			
			if(affectedRows > 0) {
				System.out.println(">>>>>>The flight is updated successfully.<<<<<<<\n");
			}else {
				System.out.println(">>>>>>Warning: The flight cannot be updated.<<<<<<<\n");
			}
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	public void deleteFlight(Flight flight) throws SQLException {
		Connection connection = null;
		try {
			connection = DBConnection.getConnection(Boolean.FALSE);
			FlightDao flightDao = new FlightDao(connection);
			flightDao.deleteFlight(flight);

			connection.commit();
			if(flightDao.findFlightById(flight.getId()) == null) {
				System.out.println("Flight Id: " + flight.getId() + " has been deleted.\n");
			}
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	public Flight getFlightById(int id) throws SQLException{
		Connection connection = null;
		Flight flight = null;
		try {
			connection = DBConnection.getConnection(Boolean.TRUE);
			FlightDao flightDao = new FlightDao(connection);
			flight = flightDao.findFlightById(id);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return flight;
	}
	
	public void listFlights() throws SQLException {
		Connection connection = null;
		List<Flight> flights = null;
		try {
			connection = DBConnection.getConnection(Boolean.FALSE);
			FlightDao flightDao = new FlightDao(connection);
			flights = flightDao.listFlight();
			connection.commit();
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		} finally {
			int index = 1;
			RouteDao routeDao = new RouteDao(connection);
			for (Flight flight : flights) {
				Route route = routeDao.getRouteById(flight.getRouteId());
				System.out.println(index + ")" + route.getOriginId() + " --> " + route.getDestinationId());
				index++;
			}
			connection.close();
		}
	}
}
