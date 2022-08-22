package toby.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import toby.connection.ConnectionProperties;

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
