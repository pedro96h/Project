package com.example.demo.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Client;
import com.example.demo.exceptions.entities.ResourceAlreadyExistsException;
import com.example.demo.exceptions.entities.ResourceNotFoundException;
import com.example.demo.repositories.ClientRepository;

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
		var client = clientRepository.findByCpf(obj.getCpf());
		if (client.isEmpty()) {
			return clientRepository.save(obj);
		}
		throw new ResourceAlreadyExistsException();
	}

	public Client findById(Long id) {
		var obj = clientRepository.findById(id);
		if (obj.isPresent()) {
			return obj.get();
		} else {
			throw new ResourceNotFoundException(id);
		}
	}

	public Client findByCpf(String cpf) {
		var optObject = clientRepository.findByCpf(cpf);
		if(optObject.isPresent()) {
			return optObject.get();
		}
		return null;
	}

	public Client findByEmail(String email) {
		var optObject =  clientRepository.findByEmail(email);
		if(optObject.isPresent()) {
			return optObject.get();
		}
		return null;
	}

	public void delete(Long id) {
		var optEntity = clientRepository.findById(id);
		if (optEntity.isEmpty()) {
			throw new ResourceNotFoundException(id);
		}
		var entity = optEntity.get();
		entity.setActive(false);
		clientRepository.save(entity);
	}

	public Client update(Long id, Client obj) {
		var optentity = clientRepository.findById(id);
		if (optentity.isEmpty()) {
			throw new ResourceNotFoundException(id);
		}
		var entity = optentity.get();
		updateData(entity, obj);
		return clientRepository.save(entity);
	}

	private void updateData(Client entity, Client obj) {
		entity.setEmail(obj.getEmail());
		entity.setCpf(obj.getCpf());
		entity.setPassword(obj.getPassword());
		entity.setFirstAccess(false);
		entity.setActive(true);
	}
}
