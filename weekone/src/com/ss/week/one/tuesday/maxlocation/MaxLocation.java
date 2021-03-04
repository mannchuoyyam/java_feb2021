/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment: Find Max Number Location
 *  Date: 2/23/21
 *  
 */
package com.ss.week.one.tuesday.maxlocation;

/**
 * @author Mannchuoy Yam
 *
 */
public class MaxLocation {
	private Integer rowNumber;
	private Integer columnNumber;
	private Integer maxValue;
	
	public MaxLocation() {
		setRowNumber(-1);
		setColumnNumber(-1);
		setMaxValue(Integer.MIN_VALUE);
	}
	
	public Integer getRowNumber() {
		return rowNumber;
	}
	public void setRowNumber(Integer rowNumber) {
		this.rowNumber = rowNumber;
	}
	
	public Integer getColumnNumber() {
		return columnNumber;
	}
	public void setColumnNumber(Integer columnNumber) {
		this.columnNumber = columnNumber;
	}
	
	public Integer getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(Integer maxValue) {
		this.maxValue = maxValue;
	}
	
	public Boolean isValidLocation() {
		return (rowNumber != -1 && columnNumber != -1);
	}
	
	public String toString() {
		return "Max value = " + maxValue + " at row " + rowNumber + " and column " + columnNumber;		
	}
}
