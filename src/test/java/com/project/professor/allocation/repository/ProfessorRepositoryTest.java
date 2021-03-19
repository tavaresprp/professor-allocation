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

import com.project.professor.allocation.entity.Professor;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class ProfessorRepositoryTest {

	@Autowired
	private ProfessorRepository professorRepository;

	@Test
	public void findAll() {

		List<Professor> professor = professorRepository.findAll();
		System.out.println(professor);

	}

	@Test
	public void findById() {

		Long id = 3L;

		Optional<Professor> optional = professorRepository.findById(id);
		Professor professor = optional.orElse(null);

		System.out.println(professor);

	}

}
