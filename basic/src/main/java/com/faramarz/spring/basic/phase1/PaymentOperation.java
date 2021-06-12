package com.faramarz.spring.basic.phase1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PaymentOperation {

    @Autowired
    @Qualifier("mobilebank")
    private Payment payment;


    public void getAtmPayment() {
        payment.pay("atm");

    }

    public void getMobileBankPayment() {
        payment.pay("mobile");
    }
}
