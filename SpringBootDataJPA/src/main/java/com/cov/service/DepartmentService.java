package com.cov.service;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cov.beans.Department;
import com.cov.exception.InvalidDepartmentIdException;
import com.cov.repo.DepartmentRepo;

@Service
public class DepartmentService {
	Logger logger = Logger.getLogger(DepartmentService.class);
	@Autowired
	DepartmentRepo departmentRepository;

	public List<Department> findAll() {
		logger.info("finding all departments");
		return departmentRepository.findAll();
	}

	public Department findById(int id) throws InvalidDepartmentIdException {
		logger.info("finding person with id: " + id);
		Optional<Department> departmentOptional = departmentRepository.findById(id);
		if (!departmentOptional.isPresent()) {

			InvalidDepartmentIdException invalidDepartmentIdException = new InvalidDepartmentIdException(
					"department id not found");
			logger.warn(invalidDepartmentIdException);

			throw invalidDepartmentIdException;

		}
		Department department = departmentOptional.get();
		logger.info("department found with id " + id + "is" + department.getName());
		return department;
	}

	public Department save(Department department) {
		logger.info("inserting a department");
		InvalidDepartmentIdException invalidDepartmentIdException = new InvalidDepartmentIdException(
				"department id not found");

		return departmentRepository.save(department);
	}

	public Department update(Department department) throws InvalidDepartmentIdException {
		logger.info("updating department ");
		Optional<Department> departmentOptional = departmentRepository.findById(department.getId());

		if (!departmentOptional.isPresent()) {
			InvalidDepartmentIdException invalidDepartmentIdException = new InvalidDepartmentIdException(
					"department id not found");
			logger.warn(invalidDepartmentIdException);
			throw invalidDepartmentIdException;
		}
		logger.info("department updated " + "is" + department.getName());
		return departmentRepository.save(department);
	}

	public Department delete(int id) throws InvalidDepartmentIdException {
		logger.info("deleting department with id " + id);
		Optional<Department> departmentOptional = departmentRepository.findById(id);

		if (!departmentOptional.isPresent()) {
			InvalidDepartmentIdException invalidDepartmentIdException = new InvalidDepartmentIdException(
					"department id not found");
			logger.warn(invalidDepartmentIdException);
			throw invalidDepartmentIdException;
		}
		Department department = departmentOptional.get();
		departmentRepository.deleteById(id);
		logger.info("department deleted " + "is with id " + id + " " + department.getName());
		return department;
	}
}