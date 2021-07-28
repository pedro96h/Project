package com.example.demo.entities.dto;

public class FistAccessDto {
	
	private String email;
	private String cpf;
	
	public FistAccessDto() {
	}

	public FistAccessDto(String email, String cpf) {
		super();
		this.email = email;
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	};
	
}
