package com.example.demo.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class ReadDocTxt {

	public String getEmailPassword() {
		String password = null;
		try (var buffRead = new BufferedReader(
				new FileReader("C:\\Users\\pedro\\Desktop\\Programação\\projetos\\pesoalInfo.txt"))) {
			password = buffRead.readLine();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return password;
	}
}
