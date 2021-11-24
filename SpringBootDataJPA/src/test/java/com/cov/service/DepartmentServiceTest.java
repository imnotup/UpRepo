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
		dept.add(new Department(1, "java"));
		dept.add(new Department(2, "Python"));
		dept.add(new Department(3, "C"));
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
		Department deptExisting = new Department(2, "python");
		when(departmentRepository.findById(2)).thenReturn(Optional.of(deptExisting));

		Department dept = departmentRepository.findById(2).get();
		assertNotNull(dept);
		assertSame(dept.getName(), "python");
		assertEquals(dept.getId(), 2);
	}

	@Test
	void testSave() {
		Department dept = new Department(4, "C++");
		when(departmentRepository.save(dept)).thenReturn(dept);

		assertNotNull(dept);

	}

	@Test
	void testUpdate() {
		Department dept = new Department(3, "CRM");
		when(departmentRepository.save(dept)).thenReturn(dept);

		Department dept1 = departmentRepository.save(dept);
		assertNotNull(dept1);
		assertSame(dept1.getName(), "CRM");
//assertEquals(person1.getId(), 3);
//fail("Not yet implemented");
	}
// @Test
// void testDelete() {
// Person personExisting = new Person(2, "jahnavi", "varma");
// when(personRepository.deleteById(2)).thenReturn(personExisting);
//
// Person person = personRepository.deleteById(2).get(2);
// assertNotNull(person);
// assertEquals(person.getId(), 2);
//
// }

}