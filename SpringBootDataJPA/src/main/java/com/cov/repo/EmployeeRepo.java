package com.cov.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cov.beans.Department;
import com.cov.beans.Employee;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Integer> {
	
	List<Employee> findByDepartment(Department department);

}
