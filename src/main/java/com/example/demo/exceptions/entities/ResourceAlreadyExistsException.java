package com.example.demo.exceptions.entities;

public class ResourceAlreadyExistsException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public ResourceAlreadyExistsException() {
		super("This feature already exists in the database");
	}
}
