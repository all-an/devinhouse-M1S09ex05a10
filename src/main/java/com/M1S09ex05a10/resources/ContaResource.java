package com.M1S09ex05a10.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.M1S09ex05a10.entities.Conta;
import com.M1S09ex05a10.services.ContaService;

@RestController
@RequestMapping(value = "/contas")
public class ContaResource {

	@Autowired 
	private ContaService service;

	@GetMapping
	public ResponseEntity<List<Conta>> findAll() {
		List<Conta> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Conta> findById(@PathVariable Long id) {
		Conta obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
