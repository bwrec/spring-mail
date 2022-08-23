package com.example.springMail.configuration;

import org.subethamail.smtp.MessageContext;
import org.subethamail.smtp.auth.LoginFailedException;
import org.subethamail.smtp.auth.UsernamePasswordValidator;

public class SimpleAuthValidatorImpl implements UsernamePasswordValidator {

	private final String CREDENTIALS_LOGIN = "superus3r";
    private final String CREDENTIALS_PASSWORD = "passw0rd";

    public void login(String username, String password, MessageContext context) throws LoginFailedException {
        if(CREDENTIALS_LOGIN.equals(username) && CREDENTIALS_PASSWORD.equals(password)){
            System.out.println("Authenticated successfully");
        }else{
            System.err.println("Invalid authentication !");
            throw new LoginFailedException();
        }
    }
}
