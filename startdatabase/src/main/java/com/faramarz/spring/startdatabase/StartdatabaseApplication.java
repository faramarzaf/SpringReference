package com.faramarz.spring.startdatabase;

import com.faramarz.spring.startdatabase.jdbc.entity.Person;
import com.faramarz.spring.startdatabase.jdbc.PersonJdbcDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

//@SpringBootApplication
public class StartdatabaseApplication /*implements CommandLineRunner*/ {


    /**
     * Every time that you run application check this address in console
     * H2 console available at '/h2-console'. Database available at 'jdbc:h2:mem:testdb'
     * JDBC URL: jdbc:h2:mem:testdb
     */

    /**
     * INSERT INTO PERSON
     * (ID, NAME, LOCATION, BIRTH_DATE)
     * VALUES(1001, 'Faramarz', 'Tehran', sysdate());
     */

    @Autowired
    PersonJdbcDao dao;


    public static void main(String[] args) {
        SpringApplication.run(StartdatabaseApplication.class, args);
    }
/*

    @Override
    public void run(String... args) throws Exception {

        System.out.println("All users --> " + dao.findAll());
        System.out.println("user (1001)-->" + dao.findById(1001));
        System.out.println("number of deleted rows -->" + dao.deleteById(1001));
        System.out.println("Inserting users --> " + dao.insert(new Person(1001,"tara","iran",new Date())));
        System.out.println("UPDATING ...");
        System.out.println("user2 updated " + dao.update(new Person(1002, "alaho", "New york",new Date())));
        System.out.println("All users --> " + dao.findAll());
    }
*/


}
