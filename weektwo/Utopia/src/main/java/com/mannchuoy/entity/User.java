/**
 *  Java_feb2021 Corhot
 *  Week 2 Evaluation
 *  Assignment: Utopia Airline
 *  Date: 3/6/21 - 3/8/21
 * 
 */
package com.mannchuoy.entity;

import java.util.List;

/**
 * @author Mannchuoy Yam
 *
 */
public class User {
	private int id;
	private int roleId;
	private String givenName;
	private String familyName;
	private String username;
	private String email;
	private String password;
	private String phone;
	private UserRole userRole;
	private List<BookingAgent> bookingAgents;
	private List<BookingUser> bookingUser;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getRoleId() {
		return roleId;
	}
	
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	public String getGivenName() {
		return givenName;
	}
	
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	
	public String getFamilyName() {
		return familyName;
	}
	
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public UserRole getUserRole() {
		return userRole;
	}
	
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	
	public List<BookingAgent> getBookingAgents() {
		return bookingAgents;
	}
	
	public void setBookingAgents(List<BookingAgent> bookingAgents) {
		this.bookingAgents = bookingAgents;
	}
	
	public List<BookingUser> getBookingUser() {
		return bookingUser;
	}
	
	public void setBookingUser(List<BookingUser> bookingUser) {
		this.bookingUser = bookingUser;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", roleId=" + roleId + ", givenName=" + givenName + ", familyName=" + familyName
				+ ", username=" + username + ", email=" + email + ", password=" + password + ", phone=" + phone
				+ ", userRole=" + userRole + "]";
	}
	
	
}
