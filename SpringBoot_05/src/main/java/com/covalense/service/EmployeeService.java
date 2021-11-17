package com.covalense.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covalense.beans.Employee;
import com.covalense.exception.invalidEmployeeIdException;
import com.covalense.repo.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepo employeeRepo;

	public List<Employee> findAll() {
		return employeeRepo.findAll();
	}

	public Employee findByID(int id) throws invalidEmployeeIdException {
		Optional<Employee> empOptional = employeeRepo.findById(id);
		if (!empOptional.isPresent()) {
			throw new invalidEmployeeIdException("Employee Id " + id + " is not exits in repository ");
		}
		return empOptional.get();
	}

	public Employee save(Employee employee) {
		return employeeRepo.save(employee);
	}

	public Employee update(Employee employee) throws invalidEmployeeIdException {
		Optional<Employee> empOptional = employeeRepo.findById(employee.getEmp_id());
		if (!empOptional.isPresent()) {
			throw new invalidEmployeeIdException("Employee Id " + employee.getEmp_id() + " is not exits in repository ");
		}
		return employeeRepo.save(employee);
	}

	public Employee delete(int id) throws invalidEmployeeIdException {
		Optional<Employee> empOptional = employeeRepo.findById(id);
		if (!empOptional.isPresent()) {
			throw new invalidEmployeeIdException("Employee Id " + id + " is not exits in repository ");
		}
		Employee employee = empOptional.get();
		employeeRepo.deleteById(id);
		return employee;
	}
}