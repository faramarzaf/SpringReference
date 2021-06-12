package com.faramarz.spring.startdatabase.jpa;

import com.faramarz.spring.startdatabase.jpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

//@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

    @Autowired
    EmployeeJpaRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("employee 1 --> " + repository.findById(10001).toString());

        System.out.println("Inserting users --> " + repository.insert(new Employee(10003, "tara", "iran", new Date())));
        System.out.println("UPDATING ...");
        System.out.println("user2 updated " + repository.update(new Employee(10002, "emp1", "tokio", new Date())));
        repository.deleteById(10002);
        System.out.println("all employees "+repository.findAll());

    }


}
