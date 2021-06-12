package com.faramarz.spring.aop.data;

import org.springframework.stereotype.Repository;

@Repository
public class Dao1 {


    public String getSomething(){
        return "dao1";
    }

}
