package com.cov.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cov.beans.Department;
import com.cov.beans.Employee;
import com.cov.repo.EmployeeRepo;

@TestInstance(Lifecycle.PER_CLASS)
class EmployeeServiceTest {

	@InjectMocks
	EmployeeService employeeService;

	@Mock
	EmployeeRepo employeeRepository;

	@BeforeAll
	public void init() {
		MockitoAnnotations.initMocks(this);
		List<Employee> emp = new ArrayList<>();
		emp.add(new Employee(1, "Rohit Sharma", Department(1, "Sales")));
		emp.add(new Employee(2, "Virat Kohli", Department(2, "Developer")));
		emp.add(new Employee(3, "KL Rahul", Department(3, "Analyst")));
		List<Employee> personList = employeeService.findAll();
		when(employeeRepository.findAll()).thenReturn(emp);

	}

	private Department Department(int i, String string) {
// TODO Auto-generated method stub
		return null;
	}

	@Test
	void testFindAll() {

		List<Employee> empList = employeeService.findAll();
		assertNotNull(empList);
		assertEquals(3, empList.size());

	}

	@Test
	void testFindById() {
		Employee empExisting = new Employee(2, "Virat Kohli", Department(2, "Developer"));
		when(employeeRepository.findById(2)).thenReturn(Optional.of(empExisting));

		Employee emp = employeeRepository.findById(2).get();
		assertNotNull(emp);
		assertSame(emp.getName(), "Virat Kohli");
		assertEquals(emp.getId(), 2);
	}

	@Test
	void testSave() {
		Employee emp = new Employee(4, "Jasprit Bumrah", Department(1, "Sales"));
		when(employeeRepository.save(emp)).thenReturn(emp);

		assertNotNull(emp);

	}

	@Test
	void testUpdate() {
		Employee emp = new Employee(3, "KL Rahul", Department(3, "Analyst"));
		when(employeeRepository.save(emp)).thenReturn(emp);

		Employee emp1 = employeeRepository.save(emp);
		assertNotNull(emp1);
		assertSame(emp1.getName(), "KL Rahul");
	}
}