package com.somecompany.someproject.config;

import bitronix.tm.BitronixTransactionManager;
import bitronix.tm.TransactionManagerServices;
import org.springframework.boot.autoconfigure.transaction.jta.JtaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.jta.JtaTransactionManager;
import org.springframework.util.StringUtils;

import javax.transaction.TransactionManager;

@Configuration
@EnableConfigurationProperties({JtaProperties.class})
public class BitronixConfig {

    private final JtaProperties jtaProperties;

    public BitronixConfig(JtaProperties jtaProperties) {
        this.jtaProperties = jtaProperties;
    }

    @Bean
    @ConfigurationProperties(
        prefix = "spring.jta.bitronix.properties"
    )
    public bitronix.tm.Configuration bitronixConfiguration() {
        bitronix.tm.Configuration config = TransactionManagerServices.getConfiguration();
        if (StringUtils.hasText(this.jtaProperties.getTransactionManagerId())) {
            config.setServerId(this.jtaProperties.getTransactionManagerId());
        }

        config.setJournal(null);
        config.setDisableJmx(true);
        return config;
    }

    @Bean
    public BitronixTransactionManager bitronixTransactionManager(bitronix.tm.Configuration configuration) {
        return TransactionManagerServices.getTransactionManager();
    }

    @Bean
    public JtaTransactionManager transactionManager(TransactionManager transactionManager) {
        return new JtaTransactionManager(transactionManager);
    }

}
