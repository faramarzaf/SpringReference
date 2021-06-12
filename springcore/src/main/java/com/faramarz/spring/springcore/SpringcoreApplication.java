package com.faramarz.spring.springcore;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.faramarz.spring.springcore") // in nabashe inja error mide
public class SpringcoreApplication {

    /**
     * @Component ----> In general case that you dont know exactly related to which layer
     *
     * vase debug kardan behtare az annotation haye zir estefade koni
     * @Controller ----> Use in web layer
     * @Service ---->   Use in business layer
     * @Repository ----> Use in data layer (db)
     */


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringcoreApplication.class);
        Sum sum = context.getBean(Sum.class);
        System.out.println(sum.Sum(4, 5));

    }

}
