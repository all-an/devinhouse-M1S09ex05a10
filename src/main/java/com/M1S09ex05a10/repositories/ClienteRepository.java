package com.M1S09ex05a10.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.M1S09ex05a10.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
