package com.M1S09ex05a10.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object id) {
		super("Dados não encontrados. Id " + id);
	}
}