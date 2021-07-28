package com.example.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.dto.FistAccessDto;
import com.example.demo.servicies.SystemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/system")
@Api(value = "API REST System")
@CrossOrigin(origins = "*")
public class SystemResource {

	@Autowired
	private SystemService systemService;

	@PostMapping
	@ApiOperation(value = "Fist access, send email with password")
	public ResponseEntity<Void> firstAccess(@RequestBody FistAccessDto fistAccessDto) {
		systemService.firstAccess(fistAccessDto);
		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/{email}/{password}")
	@ApiOperation(value = "validate client email and password")
	public ResponseEntity<Boolean> Login(@PathVariable String email, @PathVariable String password) {
		var response = systemService.login(email, password);
		return ResponseEntity.ok().body(response);
	}

}
