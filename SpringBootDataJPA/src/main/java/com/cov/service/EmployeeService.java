package com.cov.service;

import java.util.List;
import java.util.Optional;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cov.beans.Department;
import com.cov.beans.Employee;
import com.cov.exception.InvalidDepartmentIdException;
import com.cov.exception.InvalidEmployeeIdException;
import com.cov.repo.EmployeeRepo;

@Service
public class EmployeeService {
	Logger logger = Logger.getLogger(EmployeeService.class);
	@Autowired
	EmployeeRepo employeeRepository;

	public List<Employee> findAll() {
		logger.info("finding all employees");
		return employeeRepository.findAll();
	}

	public Employee findById(int id) throws InvalidEmployeeIdException {
		logger.info("finding person with id: " + id);
		Optional<Employee> empOptional = employeeRepository.findById(id);
		if (!empOptional.isPresent()) {
			InvalidEmployeeIdException invalidEmployeeIdException = new InvalidEmployeeIdException(
					"employee id not found");
			logger.warn(invalidEmployeeIdException);
			throw invalidEmployeeIdException;
		}
		Employee employee = empOptional.get();
		logger.info("department found with id " + id + "is" + employee.getName());
		return employee;
	}

	public Employee save(Employee employee) {
		logger.info("inserting a employee");
		InvalidEmployeeIdException invalidEmployeeIdException = new InvalidEmployeeIdException("employee id not found");
		return employeeRepository.save(employee);
	}

	public Employee update(Employee employee) throws InvalidEmployeeIdException {
		logger.info("updating employees ");
		Optional<Employee> empOptional = employeeRepository.findById(employee.getId());
		if (!empOptional.isPresent()) {
			InvalidEmployeeIdException invalidEmployeeIdException = new InvalidEmployeeIdException(
					"employee id not found");
			logger.warn(invalidEmployeeIdException);
			throw invalidEmployeeIdException;
		}
		logger.info("employee updated " + "is" + employee.getName());
		return employeeRepository.save(employee);
	}

	public Employee delete(int id) throws InvalidEmployeeIdException {
		logger.info("deleting department with id " + id);
		Optional<Employee> empOptional = employeeRepository.findById(id);
		if (!empOptional.isPresent()) {
			InvalidEmployeeIdException invalidEmployeeIdException = new InvalidEmployeeIdException(
					"department id not found");
			logger.warn(invalidEmployeeIdException);
			throw invalidEmployeeIdException;
		}
		Employee employee = empOptional.get();
		employeeRepository.deleteById(id);
		logger.info("department deleted " + "is with id " + id + " " + employee.getName());
		return employee;
	}

}