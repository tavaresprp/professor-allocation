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

import com.project.professor.allocation.entity.Course;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class CourseRepositoryTest {

	@Autowired
	private CourseRepository courseRepository;

	@Test
	public void findAll() {

		List<Course> course = courseRepository.findAll();
		System.out.println(course);

	}

	@Test
	public void findById() {

		Long id = 3L;

		Optional<Course> optional = courseRepository.findById(id);
		Course course = optional.orElse(null);

		System.out.println(course);

	}

}
