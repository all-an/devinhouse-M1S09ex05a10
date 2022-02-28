package com.M1S09ex05a10.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

import com.M1S09ex05a10.entities.Cliente;
import com.M1S09ex05a10.exceptions.DatabaseException;
import com.M1S09ex05a10.exceptions.ResourceNotFoundException;
import com.M1S09ex05a10.repositories.ClienteRepository;

public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public List<Cliente> findAll() {
		return repository.findAll();
	}

	public Cliente findById(Long id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Cliente insert(Cliente obj) {
		return repository.save(obj);
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

	public Cliente update(Long id, Cliente obj) {
		try {
			Cliente entity = repository.getById(id); 
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) { 
			throw new ResourceNotFoundException(id); //404Not Found
		}	
	}

	private void updateData(Cliente entity, Cliente obj) {
		entity.setName(obj.getName());
		entity.setCpf(obj.getCpf());
	}
}