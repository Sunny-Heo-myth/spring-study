package org.alan.spring.toby.chapterone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import toby.connection.AlphaConnectionMaker;
import toby.connection.BetaConnectionMaker;
import toby.connection.ConnectionMaker;
import toby.connection.properties.ConnectionProperties;

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
