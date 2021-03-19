package com.project.professor.allocation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Professor;
import com.project.professor.allocation.repository.ProfessorRepository;

@Service
public class ProfessorService {

	private ProfessorRepository professorRepository;

	public ProfessorService(ProfessorRepository professorRepository) {
		this.professorRepository = professorRepository;
	}

	public List<Professor> findAll() {
		return professorRepository.findAll();
	}

	public Professor findById(Long id) {
		return professorRepository.findById(id).orElse(null);
	}

	public Professor create(Professor professor) {
		professor.setId(null);
		try {
			return professorRepository.save(professor);
		} catch (Exception e) {
			return null;
		}

	}

	public Professor update(Professor professor) {

		if (professorRepository.existsById(professor.getId())) {
			try {
				return professorRepository.save(professor);
			} catch (Exception e) {
				return null;
			}
		} else {
			return null;
		}

	}

	public void deleteById(Long id) {
		if (professorRepository.existsById(id)) {
			professorRepository.deleteById(id);
		}
	}

	public void deleteAll() {
		professorRepository.deleteAllInBatch();
	}

}
