package com.somecompany.someproject.service.configurable;

import com.somecompany.someproject.service.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class SomeServiceConfigurableDelegator {

    @Autowired
    private SomeService someService;

    public void someMethod() {
        someService.someMethod();
    }
}
