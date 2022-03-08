package com.test;

public class Employee {
	private int emp_id;
	private String emp_name;
	private String job_id;
	
	Employee(int emp_id, String emp_name, String  job_id) {
	        this.emp_id = emp_id;
	        this.emp_name = emp_name;
	        this.job_id = job_id;
	    }
	
	
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	

}
