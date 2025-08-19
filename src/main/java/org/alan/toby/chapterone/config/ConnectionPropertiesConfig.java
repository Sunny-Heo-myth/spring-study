package org.alan.toby.chapterone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.alan.toby.chapterone.connection.properties.ConnectionProperties;

@Configuration
public class ConnectionPropertiesConfig {

    @Bean
    ConnectionProperties alphaConnectionProperties() {
        return new ConnectionProperties(
                "com.mysql.jdbc.driver",
                "jdbc:mysql://localhost/toby",
                "hsymyth",
                "gjDHD1992"
        );
    }


}
