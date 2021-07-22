package com.somecompany.someproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.core.authority.mapping.MappableAttributesRetriever;
import org.springframework.security.core.authority.mapping.SimpleMappableAttributesRetriever;

import java.util.HashSet;
import java.util.Set;

@Configuration
@ImportResource("classpath:security.xml")
public class SecurityConfig {

    @Bean
    public MappableAttributesRetriever simpleMappableAttributesRetriever() {
        SimpleMappableAttributesRetriever simpleMappableAttributesRetriever = new SimpleMappableAttributesRetriever();
        Set<String> roles = new HashSet<>();
        roles.add("specialUsers");
        simpleMappableAttributesRetriever.setMappableAttributes(roles);
        return simpleMappableAttributesRetriever;
    }

}
