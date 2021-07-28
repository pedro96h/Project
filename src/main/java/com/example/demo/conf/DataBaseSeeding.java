package com.example.demo.conf;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entities.Client;
import com.example.demo.entities.Product;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.util.ReadDocTxt;
import com.example.demo.util.SendEmail;

@Configuration
public class DataBaseSeeding implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private SendEmail sendEmail;

	@Autowired
	private ReadDocTxt readDocTxt;

	@Override
	public void run(String... args) throws Exception {

		var c1 = new Client("pedro@gmail.com","111-222-333-44","1234",true,false);
		var c2 = new Client("bruna@gmail.com","222-333-444-55","2345",true,false);
		var c3 = new Client("jose@gmail.com","333-444-555-66","3456",true,true);
		var c4 = new Client("carla@gmail.com","444-555-666-77","4567",false,true);
		var c5 = new Client("jessica@gmail.com","555-666-777-88","5678",true,true);
		clientRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5));

		var p1 = new Product("coca-cola", "Refrigerante", 5.50, 100);
		var p2 = new Product("guarana antartica", "Refrigerante", 5.20, 150);
		var p3 = new Product("Telefone", "eletronico", 1150, 10);
		var p4 = new Product("notebook", "eletronico", 3700, 23);
		var p5 = new Product("lapis", "material escolar", 1.25, 30);
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

//		sendEmail.sendEmail("pedro96h@gmail.com", readDocTxt.getEmailPassword(),"pedro96h@gmail.com");
	}

}
