package com.M1S09ex05a10.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.M1S09ex05a10.entities.Cliente;
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
	
	public Conta insert(Conta obj) {
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
	
	public Conta update(Long id, Conta obj) {
		try {
			Conta entity = repository.getById(id);
			
			updateData(entity, obj.getCliente(), obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) { 
			throw new ResourceNotFoundException(id); //404Not Found
		}	
	}
	
	public Conta deposito(Long id, Conta obj) {
		try {
			Conta entity = repository.getById(id);
			Double valorDeposito = obj.getValorOperacao();
			entity.setSaldo(entity.getSaldo() + valorDeposito);
			entity.setMensagem("Depósito Realizado!");
			return repository.save(entity);
		} catch (EntityNotFoundException e) { 
			throw new ResourceNotFoundException(id); //404Not Found
		}	
	}
	
	public Conta saque(Long id, Conta obj) {
		try {
			Conta entity = repository.getById(id);
			
			updateData(entity, obj.getCliente(), obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) { 
			throw new ResourceNotFoundException(id); //404Not Found
		}	
	}

	private void updateData(Conta anterior, Cliente obj, Conta novosDados) {
		anterior.setSaldo(novosDados.getSaldo());
		anterior.setCliente(obj);
	}
}
