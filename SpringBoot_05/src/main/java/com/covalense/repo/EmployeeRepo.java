package com.covalense.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.covalense.beans.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
