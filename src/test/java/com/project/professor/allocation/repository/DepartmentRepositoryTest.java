package com.project.professor.allocation.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.entity.Department;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class DepartmentRepositoryTest {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Test
	public void findAll() {

		List<Department> departments = departmentRepository.findAll();
		System.out.println(departments);

	}

	@Test
	public void findById() {

		Long id = 3L;

		Optional<Department> optional = departmentRepository.findById(id);
		Department department = optional.orElse(null);

		System.out.println(department);

	}

	@Test
	public void save_create() {

		Department d = new Department();
		d.setNameDepartment("Departamento de Teste");

		Department department = departmentRepository.save(d);

		System.out.println(department);

	}

	@Test
	public void save_update() {

		Department d = new Department();
		d.setId(13L);
		d.setNameDepartment("Departamento de Teste Update");

		Department department = departmentRepository.save(d);

		System.out.println(department);

	}

	@Test
	public void delete() {

		Long id = 13L;

		if (departmentRepository.existsById(id)) {
			departmentRepository.deleteById(id);
		}

	}
	
	@Test
	public void deleteAll() {

//		departmentRepository.deleteAllInBatch();

	}

}
