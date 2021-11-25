package com.cov.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cov.beans.Department;
import com.cov.exception.InvalidDepartmentIdException;
import com.cov.service.DepartmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "API to perform operations in Department", description = "This API provides the capability to perform "
		+ "different crud operations on Department repository")

@RestController
@RequestMapping("/department")
public class DepartmentController {
	static Logger logger = Logger.getLogger(DepartmentController.class);

	@Autowired
	DepartmentService departmentService;

	@ApiOperation(value = "Search a Sigle department base don ID")
	@GetMapping("/{id}")
	public Department find(@PathVariable int id) throws InvalidDepartmentIdException {
		logger.info("finding a department with id " + id);
		Department department = departmentService.findById(id);
		logger.info("department found with id " + id + " is" + department.getName());
		return department;

	}

	@ApiOperation(value = "Show the list of all the departments", produces = "Application.xml")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list of departments"),
			@ApiResponse(code = 401, message = "You are not authorized to view the Repository"),
			@ApiResponse(code = 403, message = "Accessing the resources you are trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@GetMapping()
	public List<Department> findAll() {
		logger.info("finding all departments");
		return departmentService.findAll();

	}

	@ApiOperation(value = "Inserting a department ")
	@PostMapping()
	public Department insertPerson(@RequestBody Department department) {
		logger.info("inserting a department with " + department.getName());

		return departmentService.save(department);

	}

	@ApiOperation(value = "performing edit operation on the department")
	@PutMapping()
	public Department edit(@RequestBody Department department) throws InvalidDepartmentIdException {
		logger.info("editing a department with " + department.getName());

		return departmentService.update(department);
	}

	@ApiOperation(value = "performing delete operation on the available departments")
	@DeleteMapping("/{id}")
	public Department delete(@PathVariable int id) throws InvalidDepartmentIdException {
		logger.info("deleting a department with id " + id);

		return departmentService.delete(id);
	}

}