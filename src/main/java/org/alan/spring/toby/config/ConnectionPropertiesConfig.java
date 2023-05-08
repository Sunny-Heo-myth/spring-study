package org.alan.spring.toby.config;

import org.alan.spring.toby.connection.ConnectionProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
