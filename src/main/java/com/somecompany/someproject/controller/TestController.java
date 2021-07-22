package com.somecompany.someproject.controller;

import com.somecompany.someproject.model.SomeEntity;
import com.somecompany.someproject.repo.SomeRepository;
import com.somecompany.someproject.service.JmsMessageService;
import com.somecompany.someproject.service.configurable.SomeServiceConfigurableDelegator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class TestController {

    private static final SomeServiceConfigurableDelegator someServiceConfigurableDelegator = new SomeServiceConfigurableDelegator();

    @Autowired
    private JmsMessageService jmsMessageService;
    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/test")
    public String test() {
        someServiceConfigurableDelegator.someMethod();
        return "test";
    }

    @GetMapping("/jmsTest")
    public void jmsTest() {
        jmsMessageService.sendMessage("someMessage");
    }

}
