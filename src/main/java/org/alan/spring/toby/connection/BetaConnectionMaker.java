package org.alan.spring.toby.connection;

import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@RequiredArgsConstructor
public class BetaConnectionMaker implements ConnectionMaker{

    private final ConnectionProperties properties;

    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        Class.forName(properties.driver());
        return DriverManager.getConnection(properties.resource(), properties.user(), properties.password());
    }
}
