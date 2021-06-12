package com.spring.LoginWebApp.service;


import com.spring.LoginWebApp.entity.User;
import com.spring.LoginWebApp.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User save(UserRegistrationDto registrationDto);
    Boolean existsEmployeeByEmail(String email);


}
