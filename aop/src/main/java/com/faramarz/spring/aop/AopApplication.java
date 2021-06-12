package com.faramarz.spring.aop;

import com.faramarz.spring.aop.business.Business1;
import com.faramarz.spring.aop.business.Business2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopApplication implements CommandLineRunner {

	@Autowired
	Business1 business1;

	@Autowired
	Business2 business2;


	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
		System.out.println("i am main");
	}

	@Override
	public void run(String... args) throws Exception {
		/**
		 * When you want to execute some piece of code exactly before the application startup completes,
		 * you can use it then.
		 */
		System.out.println(business1.calculateSomething());
		System.out.println(business2.calculateSomething());

	}
}
