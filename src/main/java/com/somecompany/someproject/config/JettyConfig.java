package com.somecompany.someproject.config;

import org.eclipse.jetty.security.HashLoginService;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.jetty.JettyServerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JettyConfig implements EmbeddedServletContainerCustomizer {

    private String realmName;

    @Override
    public void customize(ConfigurableEmbeddedServletContainer jettyContainer) {
        ((JettyEmbeddedServletContainerFactory)jettyContainer).addServerCustomizers(jettyLoginCustomizer());
    }

    @Bean
    public JettyServerCustomizer jettyLoginCustomizer() {
        return server -> {
            HashLoginService loginService = new HashLoginService(realmName);
            loginService.setConfig("./src/main/resources/static/jetty-realm.properties");
            server.addBean(loginService);
        };
    }
}
