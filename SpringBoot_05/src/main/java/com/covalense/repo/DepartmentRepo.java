package com.covalense.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.covalense.beans.Department;

public interface DepartmentRepo extends JpaRepository<Department, Integer>{
	 
}

