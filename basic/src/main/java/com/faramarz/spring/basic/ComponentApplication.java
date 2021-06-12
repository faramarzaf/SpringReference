package com.faramarz.spring.basic;

import com.faramarz.spring.basic.phase3componentscan.ComponentDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class ComponentApplication {
    private static Logger logger = LoggerFactory.getLogger(BasicApplication.class);

    /**
     * @SpringBootApplication by default vase component tuye in padkage migarde ---> com.faramarz.spring.basic
     * age moshkeli vase peyda nakardane component tuye baghie package ha shodi -->
     * ehtemalan yeki az solution ha componentScan
     * @ComponentScan("package_address_that_you_want_include")
     */


    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ComponentApplication.class, args);


        ComponentDAO componentDAO = context.getBean(ComponentDAO.class);
        logger.info("{}", componentDAO);
    }

}
