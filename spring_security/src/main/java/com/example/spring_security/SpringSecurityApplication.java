package com.example.spring_security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
		// username=user/ password in console when you run
        /**
         * by default
         * localhost:8080/login
         * localhost:8080/logout
         */


		/**
		 * JWT
		 * 	Client sends credentials to the server
		 * 	Server validates credentials and creates and sign tokens,finally sends token to client
		 * 	Client send tokens for each request
		 * 	Server validates token
		 */
	}

}
