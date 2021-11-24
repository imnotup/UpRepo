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
import com.cov.repo.DepartmentRepo;

@TestInstance(Lifecycle.PER_CLASS)
class DepartmentServiceTest {

	@InjectMocks
	DepartmentService departmentService;

	@Mock
	DepartmentRepo departmentRepository;

	@BeforeAll
	public void init() {
		MockitoAnnotations.initMocks(this);
		List<Department> dept = new ArrayList<>();
		dept.add(new Department(1, "Sales"));
		dept.add(new Department(2, "Developer"));
		dept.add(new Department(3, "Analyst"));
		List<Department> personList = departmentService.findAll();
		when(departmentRepository.findAll()).thenReturn(dept);

	}

	@Test
	void testFindAll() {

		List<Department> deptList = departmentService.findAll();
		assertNotNull(deptList);
		assertEquals(3, deptList.size());

	}

	@Test
	void testFindById() {
		Department deptExisting = new Department(2, "Developer");
		when(departmentRepository.findById(2)).thenReturn(Optional.of(deptExisting));

		Department dept = departmentRepository.findById(2).get();
		assertNotNull(dept);
		assertSame(dept.getName(), "Developer");
		assertEquals(dept.getId(), 2);
	}

	@Test
	void testSave() {
		Department dept = new Department(4, "Data Engineer");
		when(departmentRepository.save(dept)).thenReturn(dept);

		assertNotNull(dept);

	}

	@Test
	void testUpdate() {
		Department dept = new Department(3, "PHP Developer");
		when(departmentRepository.save(dept)).thenReturn(dept);

		Department dept1 = departmentRepository.save(dept);
		assertNotNull(dept1);
		assertSame(dept1.getName(), "PHP Developer");
	}
}