package com.M1S09ex05a10.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.M1S09ex05a10.entities.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

}