package com.somecompany.someproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }
}
