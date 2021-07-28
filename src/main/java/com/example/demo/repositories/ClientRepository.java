package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {
	
	 List<Client> findByActive(boolean activate);
	 
	 Client findByCpf(String cpf);
	 
	 Client findByEmail(String email);
}
