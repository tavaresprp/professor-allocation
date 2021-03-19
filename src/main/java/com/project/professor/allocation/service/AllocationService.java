package com.project.professor.allocation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Allocation;
import com.project.professor.allocation.repository.AllocationRepository;

@Service
public class AllocationService {

	private AllocationRepository allocationRepository;

	public AllocationService(AllocationRepository allocationRepository) {
		this.allocationRepository = allocationRepository;
	}

	public List<Allocation> findAll() {
		return allocationRepository.findAll();
	}

	public Allocation findById(Long id) {
		return allocationRepository.findById(id).orElse(null);
	}

	public Allocation create(Allocation allocation) {
		allocation.setId(null);
		try {
			return allocationRepository.save(allocation);
		} catch (Exception e) {
			return null;
		}

	}

	public Allocation update(Allocation allocation) {

		if (allocationRepository.existsById(allocation.getId())) {
			try {
				return allocationRepository.save(allocation);
			} catch (Exception e) {
				return null;
			}
		} else {
			return null;
		}
	}

	public void deleteById(Long id) {
		if (allocationRepository.existsById(id)) {
			allocationRepository.deleteById(id);
		}
	}

	public void deleteAll() {
		allocationRepository.deleteAllInBatch();
	}

}
