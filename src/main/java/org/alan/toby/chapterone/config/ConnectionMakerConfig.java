package org.alan.toby.chapterone.config;

import org.alan.toby.chapterone.connection.AlphaConnectionMaker;
import org.alan.toby.chapterone.connection.BetaConnectionMaker;
import org.alan.toby.chapterone.connection.ConnectionMaker;
import org.alan.toby.chapterone.connection.properties.ConnectionProperties;
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
