package com.spring.LoginWebApp.web;

import com.spring.LoginWebApp.service.UserService;
import com.spring.LoginWebApp.web.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    private UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto, Model model) {
        Boolean existsEmployeeByEmail = userService.existsEmployeeByEmail(registrationDto.getEmail());
        if (existsEmployeeByEmail) {
            model.addAttribute("emailExists", "Error");
            return "registration";
        }

        userService.save(registrationDto);
        return "redirect:/registration?success"; // <div th:if="${param.success}">
    }
}
