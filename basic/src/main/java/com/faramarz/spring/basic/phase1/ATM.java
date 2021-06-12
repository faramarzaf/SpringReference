package com.faramarz.spring.basic.phase1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("atm")
public class ATM implements Payment {


    @Override
    public void pay(String msg) {
        System.out.println(msg);
    }

}
