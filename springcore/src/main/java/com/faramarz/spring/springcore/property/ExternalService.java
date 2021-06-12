package com.faramarz.spring.springcore.property;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExternalService {

    @Value("${external.service.url}")
    private String url;

    public String returnServiceUrl() {
        return url;
    }
}
