package com.faramarz.spring.basic.phase1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("mobilebank")
public class MobileBank implements Payment {

    @Override
    public void pay(String msg) {
        System.out.println(msg);
    }


}
