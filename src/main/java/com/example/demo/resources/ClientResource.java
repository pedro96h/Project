package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Client;
import com.example.demo.servicies.ClientService;

@RestController
@RequestMapping(value = "/api/clients")
public class ClientResource {

	@Autowired
	private ClientService clientService;

	@GetMapping
	public ResponseEntity<List<Client>> findAll() {
		List<Client> list = clientService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/allActiveClients")
	public ResponseEntity<List<Client>> findAllActiveClients() {
		List<Client> list = clientService.findAllActiveClients();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/allNotActiveClients")
	public ResponseEntity<List<Client>> findAllNotActiveClients() {
		List<Client> list = clientService.findAllNotActiveClients();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Client> findById(@PathVariable Long id) {
		var objClient = clientService.findById(id);
		if (objClient != null) {
			return ResponseEntity.ok().body(objClient);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@PostMapping
	public ResponseEntity<Client> insert(@RequestBody Client obj) {
		obj = clientService.insert(obj);
		if (obj == null) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(obj);
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		clientService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client obj) {
		obj = clientService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
