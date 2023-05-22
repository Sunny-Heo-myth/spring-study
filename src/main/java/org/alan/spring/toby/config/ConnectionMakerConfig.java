package org.alan.spring.toby.config;

import org.alan.spring.toby.connection.AlphaConnectionMaker;
import org.alan.spring.toby.connection.BetaConnectionMaker;
import org.alan.spring.toby.connection.ConnectionMaker;
import org.alan.spring.toby.connection.ConnectionProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConnectionMakerConfig {

    @Bean
    public ConnectionMaker alphaConnectionMaker(ConnectionProperties properties) {
        return new AlphaConnectionMaker(properties);
    }

    @Bean
    public ConnectionMaker betaConnectionMaker(ConnectionProperties properties) {
        return new BetaConnectionMaker(properties);
    }
}
