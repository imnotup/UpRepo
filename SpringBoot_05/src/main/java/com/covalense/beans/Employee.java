package com.covalense.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.covalense.repo.EmployeeRepo;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int emp_id;
	private String empname;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "departmentid", nullable = false)
	Department department;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int emp_id, String empname, Department department) {
		super();
		this.emp_id = emp_id;
		this.empname = empname;
		this.department = department;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", empname=" + empname + ", department="
				+ department + "]";
	}

	public static EmployeeRepo findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}