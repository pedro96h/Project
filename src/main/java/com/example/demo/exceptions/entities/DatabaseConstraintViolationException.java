package com.example.demo.exceptions.entities;

public class DatabaseConstraintViolationException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public DatabaseConstraintViolationException(String msg) {
		super(msg);
	}
}
