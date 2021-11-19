package com.cov.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.cov.beans.Department;

public interface DepartmentRepo extends CrudRepository<Department, Integer> {

	Optional<Department> findById(int id);

}
