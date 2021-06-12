package com.faramarz.spring.springcore;


import com.faramarz.spring.springcore.xmlconfig.XmlDao;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

@Configuration
//@ComponentScan("com.faramarz.spring.springcore") we used ComponentScan in XML file
public class SpringcoreXmlApplication {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        XmlDao dao = context.getBean(XmlDao.class);

        /**
         *below code show list of total beans in application
         */
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));

        System.out.println(dao.getXmlJdbcConnection());

    }

}
