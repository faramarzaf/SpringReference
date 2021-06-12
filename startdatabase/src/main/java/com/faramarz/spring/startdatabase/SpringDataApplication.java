package com.faramarz.spring.startdatabase;

import com.faramarz.spring.startdatabase.jpa.entity.Employee;
import com.faramarz.spring.startdatabase.newWay.EmployeeSpringDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

    @Autowired
    EmployeeSpringDataRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("employee 1 --> " + repository.findById(10001));

        System.out.println("Inserting users --> " + repository.save(new Employee(10005, "tara", "iran", new Date())));
        System.out.println("UPDATING ...");
        System.out.println("user2 updated " + repository.save(new Employee(10003, "emp1", "tokio", new Date())));
        repository.deleteById(10001);
        System.out.println("all employees " + repository.findAll());

    }


}
