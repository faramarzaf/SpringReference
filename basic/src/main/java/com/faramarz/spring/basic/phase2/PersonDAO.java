package com.faramarz.spring.basic.phase2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class PersonDAO {

    @Autowired
    JdbcConnection jdbcConnection;

    public JdbcConnection getJdbcConnection() {
        return jdbcConnection;
    }

    public void setJdbcConnection(JdbcConnection jdbcConnection) {
        this.jdbcConnection = jdbcConnection;
    }


    /**
     * As soon as bean is created and initialed with @Autowired
     * the @PostConstruct method will be called. The PostConstruct annotation is used on a method that needs to be executed
     * after dependency injection is done.
     */
    @PostConstruct
    public void postConstruct() {
        System.out.println("jdbc connection bean created.");
    }

    /**
     * Called before container remove bean instance
     */
    @PreDestroy
    public void preDestroy() {
        System.out.println("jdbc connection bean destroyed.");
    }


}
