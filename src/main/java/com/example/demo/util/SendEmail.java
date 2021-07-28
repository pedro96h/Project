package com.example.demo.util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class SendEmail {

	public void sendEmail(String yourEmail, String youEmailPassword, String receveEmail) {
		var simpleEmail = new SimpleEmail();
		simpleEmail.setHostName("smtp.googlemail.com");
		simpleEmail.setSmtpPort(465);
		simpleEmail.setAuthenticator(new DefaultAuthenticator(yourEmail, youEmailPassword));
		simpleEmail.setSSLOnConnect(true);
		try {
			simpleEmail.setFrom(yourEmail);
			simpleEmail.setSubject("New register, your temporary password!");
			simpleEmail.setMsg("Your temporary password is : " + PasswordGeneratior.getNewPassword());
			simpleEmail.addTo(receveEmail);
			simpleEmail.send();
		} catch (Exception e) {
			// mandar uma exceção personalizada para esse tipo de email
			System.out.println(e.getMessage());
		}
	}
}
