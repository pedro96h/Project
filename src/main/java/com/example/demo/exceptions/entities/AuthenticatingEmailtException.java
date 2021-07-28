package com.example.demo.exceptions.entities;

public class AuthenticatingEmailtException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public AuthenticatingEmailtException(String msg) {
		super(msg);
	}
}
