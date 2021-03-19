package com.project.professor.allocation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Department;
import com.project.professor.allocation.repository.DepartmentRepository;

@Service
public class DepartmentService {

	private DepartmentRepository departmentRepository;

	public DepartmentService(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	public List<Department> findAll() {
		return departmentRepository.findAll();
	}

	public Department findById(Long id) {
		return departmentRepository.findById(id).orElse(null);
	}

	public Department create(Department department) {
		department.setId(null);
		try {
			return departmentRepository.save(department);
		} catch (Exception e) {
			return null;
		}

	}

	public Department update(Department department) {

		if (departmentRepository.existsById(department.getId())) {
			try {
				return departmentRepository.save(department);
			} catch (Exception e) {
				return null;
			}
		} else {
			return null;
		}
	}
	
	public void deleteById(Long id) {
		if (departmentRepository.existsById(id)) {
			departmentRepository.deleteById(id);
		}
	}
	
	public void deleteAll() {
		departmentRepository.deleteAllInBatch();
	}

}
