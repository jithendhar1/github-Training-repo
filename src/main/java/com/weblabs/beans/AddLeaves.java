package com.weblabs.beans;

import java.sql.Timestamp;

public class AddLeaves {
	
	private String id;
	private String Employees;
	private String Starting_Ats;
	private String Ending_On;
	private String Days;
	private String Reason;
	private String Employee_Id;
	public String getEmployee_Id() {
		return Employee_Id;
	}
	public void setEmployee_Id(String employee_Id) {
		Employee_Id = employee_Id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getEmployee() {
		return Employee;
	}
	public void setEmployee(String employee) {
		Employee = employee;
	}
	public String getStarting_At() {
		return Starting_At;
	}
	public void setStarting_At(String starting_At) {
		Starting_At = starting_At;
	}
	public String getEnding_On() {
		return Ending_On;
	}
	public void setEnding_On(String ending_On) {
		Ending_On = ending_On;
	}
	public String getDays() {
		return Days;
	}
	public void setDays(String days) {
		Days = days;
	}
	public String getReason() {
		return Reason;
	}
	public void setReason(String reason) {
		Reason = reason;
	}
	
	
	public void setTime_Added(Object timestamp) {
		// TODO Auto-generated method stub
		
	}
	
	
}
