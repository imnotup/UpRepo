package com.cov.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cov.beans.Department;
import com.cov.beans.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	

}
