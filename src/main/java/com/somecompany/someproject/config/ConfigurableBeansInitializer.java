package com.somecompany.someproject.config;

import org.aspectj.lang.Aspects;
import org.springframework.beans.factory.aspectj.AnnotationBeanConfigurerAspect;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class ConfigurableBeansInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        Aspects.aspectOf(AnnotationBeanConfigurerAspect.class)
                .setBeanFactory(((GenericApplicationContext) configurableApplicationContext).getDefaultListableBeanFactory());
    }
}
