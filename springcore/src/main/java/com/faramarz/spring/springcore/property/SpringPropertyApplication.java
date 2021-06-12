package com.faramarz.spring.springcore.property;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan // by default is this address package
@PropertySource("classpath:app.properties")
public class SpringPropertyApplication {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringPropertyApplication.class);
        ExternalService service = context.getBean(ExternalService.class);
        System.out.println(service.returnServiceUrl());

    }

}
