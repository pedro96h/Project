package com.example.demo.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Client;
import com.example.demo.entities.dto.FistAccessDto;
import com.example.demo.exceptions.entities.ResourceAlreadyExistsException;
import com.example.demo.util.ReadDocTxt;
import com.example.demo.util.SendEmail;

@Service
public class SystemService {

	@Autowired
	private ClientService clientService;

	@Autowired
	private ReadDocTxt readDocTxt;

	@Autowired
	private SendEmail sendEmail;

	public Client findByCpf(String cpf) {
		return clientService.findByCpf(cpf);
	}

	public void addClient(String email, String cpf, String randomPassword) {
		clientService.insert(new Client(email, cpf, randomPassword, true, true));
	}

	public boolean login(String email, String password) {
		var response = clientService.findByEmail(email);
		if(response == null) {
			return false;
		}
		if (response.getPassword().equals(password) && response.isActive()) {
			return true;
		} else {
			return false;	
		}
	}

	public void firstAccess(FistAccessDto fistAccessDto) {
		var client = clientService.findByCpf(fistAccessDto.getCpf());
		if (client != null) {
			throw new ResourceAlreadyExistsException();
		}
		var randomPassword = sendEmail.sendEmail("pedro96h@gmail.com", readDocTxt.getEmailPassword(),
				"pedro96h@gmail.com");
		this.addClient(fistAccessDto.getEmail(), fistAccessDto.getCpf(), randomPassword);
	}
}
