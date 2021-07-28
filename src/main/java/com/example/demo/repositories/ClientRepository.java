package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {
	
	 List<Client> findByActive(boolean activate);
	 
	 Optional<Client> findByCpf(String cpf);
	 
	 Optional<Client> findByEmail(String email);
}
