package com.somecompany.someproject.service;

import com.somecompany.someproject.model.SomeEntity;
import com.somecompany.someproject.repo.SomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JmsMessageService {

    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private SomeRepository someRepository;
    @Autowired
    private ApplicationContext applicationContext;

    @JmsListener(destination = "someQueue")
    public void handleMessage(String message) {
        final SomeEntity someEntity = new SomeEntity();

        try {
            someRepository.save(someEntity);
        } catch (DataAccessException e) {
            System.out.println("error, ok, still processing income message and we shouldn't accept it again");
        }

        System.out.println("Accepted message: " + message);
    }

    public void sendMessage(String message) {
        jmsTemplate.convertAndSend("someQueue", message);
    }
}
