package com.covalense.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	private String name;
	
	@OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
	public List<Employee> employees = new ArrayList<>();
	 
	 
	public Department(int id, String name) {
		super();
		Id = id;
		this.name = name;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [Id=" + Id + ", name=" + name + "]";
	}

}
