package com.M1S09ex05a10;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.M1S09ex05a10.entities.Cliente;
import com.M1S09ex05a10.entities.Conta;
import com.M1S09ex05a10.repositories.ClienteRepository;
import com.M1S09ex05a10.repositories.ContaRepository;

@SpringBootApplication
public class DevinhouseM1S09ex05a10Application implements CommandLineRunner{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ContaRepository contaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DevinhouseM1S09ex05a10Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Cliente c1 = new Cliente(1L, "José Vieira", "67024317086");
		Cliente c2 = new Cliente(2L, "Amanda Marques", "56205307014");
		
		clienteRepository.saveAll(Arrays.asList(c1, c2));
		
		Conta conta1 = new Conta(1L, c1);
		Conta conta2 = new Conta(2L, c2);
		
		contaRepository.saveAll(Arrays.asList(conta1,conta2));
	
	}

}
