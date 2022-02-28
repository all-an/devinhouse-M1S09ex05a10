package com.M1S09ex05a10.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.M1S09ex05a10.entities.Conta;
import com.M1S09ex05a10.exceptions.DatabaseException;
import com.M1S09ex05a10.exceptions.ResourceNotFoundException;
import com.M1S09ex05a10.repositories.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository repository;

	public List<Conta> findAll() {
		return repository.findAll();
	}

	public Conta findById(Long id) {
		Optional<Conta> obj = repository.findById(id);
		return obj.get();
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
}
