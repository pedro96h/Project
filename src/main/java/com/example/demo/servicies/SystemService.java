package com.example.demo.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Client;

@Service
public class SystemService {

	@Autowired
	private ClientService clientService;
	
	public Client findByCpf(String cpf) {
		return clientService.findByCpf(cpf);
	}
	
	public void addClient(String email,String cpf,String randomPassword) {
		clientService.insert(new Client(email, cpf, randomPassword, true, true));
	}
	
	public boolean login(String email, String password) {
		var response = clientService.findByEmail(email);
		if(response.getPassword().equals(password)) {
			return true;
		}
		return false;
	}
}
