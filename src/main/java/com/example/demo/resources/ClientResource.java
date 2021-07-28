package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/clients")
@Api(value = "API REST Clients")
@CrossOrigin(origins = "*")
public class ClientResource {

	@Autowired
	private ClientService clientService;

	@GetMapping
	@ApiOperation(value = "List all clients")
	public ResponseEntity<List<Client>> findAll() {
		List<Client> list = clientService.findAll();
		if (list.isEmpty()) {
			ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/allActiveClients")
	@ApiOperation(value = "List all activated clients")
	public ResponseEntity<List<Client>> findAllActiveClients() {
		List<Client> list = clientService.findAllActiveClients();
		if (list.isEmpty()) {
			ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/allNotActiveClients")
	@ApiOperation(value = "List all not activated clients")
	public ResponseEntity<List<Client>> findAllNotActiveClients() {
		List<Client> list = clientService.findAllNotActiveClients();
		if (list.isEmpty()) {
			ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	@ApiOperation(value = "Get a client by id")
	public ResponseEntity<Client> findById(@PathVariable Long id) {
		var objClient = clientService.findById(id);
		return ResponseEntity.ok().body(objClient);
	}

	@PostMapping
	@ApiOperation(value = "Insert a new client in database")
	public ResponseEntity<Client> insert(@RequestBody Client obj) {
		var response = clientService.insert(obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@DeleteMapping(value = "/{id}")
	@ApiOperation(value = "Delete a client by id")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		clientService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	@ApiOperation(value = "Update a client by id")
	public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client obj) {
		obj = clientService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
