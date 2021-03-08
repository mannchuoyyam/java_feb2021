/**
 *  Java_feb2021 Corhot
 *  Week 2 Evaluation
 *  Assignment: Utopia Airline
 *  Date: 3/6/21 - 3/8/21
 * 
 */
package com.mannchuoy.dao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author Mannchuoy Yam
 *
 */

@RunWith(Suite.class)
@SuiteClasses({AirplaneDaoTest.class, AirplaneTypeDaoTest.class, 
	AirportDaoTest.class, DBConnectionTest.class, 
	FlightDaoTest.class, RouteDaoTest.class})
public class UtopiaUnitTest {

}
