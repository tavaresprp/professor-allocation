package com.project.professor.allocation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Course;
import com.project.professor.allocation.repository.CourseRepository;

@Service
public class CourseService {

	private CourseRepository courseRepository;

	public CourseService(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	public Course findById(Long id) {
		return courseRepository.findById(id).orElse(null);
	}

	public Course create(Course course) {
		course.setId(null);
		try {
			return courseRepository.save(course);
		} catch (Exception e) {
			return null;
		}

	}

	public Course update(Course course) {

		if (courseRepository.existsById(course.getId())) {
			try {
				return courseRepository.save(course);
			} catch (Exception e) {
				return null;
			}
		} else {
			return null;
		}
	}
	
	public void deleteById(Long id) {
		if (courseRepository.existsById(id)) {
			courseRepository.deleteById(id);
		}
	}
	
	public void deleteAll() {
		courseRepository.deleteAllInBatch();
	}

}
