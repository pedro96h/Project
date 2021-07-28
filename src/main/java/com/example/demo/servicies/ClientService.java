package com.example.demo.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Client;
import com.example.demo.repositories.ClientRepository;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	public List<Client> findAllActiveClients() {
		return clientRepository.findByActive(true);
	}

	public List<Client> findAllNotActiveClients() {
		return clientRepository.findByActive(false);
	}
	
	public Client insert(Client obj) {
	  	return clientRepository.save(obj);
	}

	public Client findById(Long id) {
		Optional<Client> obj = clientRepository.findById(id);
		if (obj.isPresent()) {
			return obj.get();
		} else {
			return null;
		}
	}
	
	public Client findByCpf(String cpf) {
		return clientRepository.findByCpf(cpf);
	}
	
	public Client findByEmail(String email) {
		return clientRepository.findByCpf(email);
	}

	public void delete(Long id) {
		try {
			Client entity = clientRepository.getOne(id);
			entity.setActive(false);
			clientRepository.save(entity);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Client update(Long id, Client obj) {
		try {
			Client entity = clientRepository.getOne(id);
			updateData(entity,obj);
			return clientRepository.save(entity);	
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	private void updateData(Client entity, Client obj) {
		entity.setEmail(obj.getEmail());
		entity.setCpf(obj.getCpf());
		entity.setPassword(obj.getPassword());
		entity.setFirstAccess(false);
		entity.setActive(true);
	}

}
