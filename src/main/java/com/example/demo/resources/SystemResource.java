package com.example.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.servicies.SystemService;
import com.example.demo.util.ReadDocTxt;
import com.example.demo.util.SendEmail;

@RestController
@RequestMapping(value = "/api/system")
public class SystemResource {

	@Autowired
	private SystemService systemService;

	@Autowired
	private ReadDocTxt readDocTxt;

	@Autowired
	private SendEmail sendEmail;

	@GetMapping(value = "firstAccess/{email}/{cpf}") // aqui era para ser um post
	public ResponseEntity<Void> firstAccess(@PathVariable String email, @PathVariable String cpf) {
		var objClient = systemService.findByCpf(cpf);
		if (objClient != null) {
			return ResponseEntity.noContent().build();
		} else {
			var randomPassword = readDocTxt.getEmailPassword();
			sendEmail.sendEmail("pedro96h@gmail.com", randomPassword, "pedro96h@gmail.com");
			systemService.addClient(email, cpf, randomPassword);
			return ResponseEntity.ok().build();
		}
	}

	@GetMapping(value = "/{email}/{password}") // validar depois se o cliente localizado é primeiro acesso
	public ResponseEntity<Boolean> Login(@PathVariable String email, @PathVariable String password) {
		var response = systemService.login(email, password);
		if (response) {
			return ResponseEntity.ok().body(true);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

}
