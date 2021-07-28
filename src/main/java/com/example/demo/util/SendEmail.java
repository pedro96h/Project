package com.example.demo.util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.entities.AuthenticatingEmailtException;

@Service
public class SendEmail {

	public String sendEmail(String yourEmail, String youEmailPassword, String receveEmail) {
		var simpleEmail = new SimpleEmail();
		simpleEmail.setHostName("smtp.googlemail.com");
		simpleEmail.setSmtpPort(465);
		simpleEmail.setAuthenticator(new DefaultAuthenticator(yourEmail, youEmailPassword));
		simpleEmail.setSSLOnConnect(true);
		try {
			var randonPass = PasswordGeneratior.getNewPassword();
			simpleEmail.setFrom(yourEmail);
			simpleEmail.setSubject("New register, your temporary password!");
			simpleEmail.setMsg("Your temporary password is : " + randonPass);
			simpleEmail.addTo(receveEmail);
			simpleEmail.send();
			return randonPass;
		} catch (Exception e) {
			throw new AuthenticatingEmailtException(e.getMessage());
		}
	}
}
