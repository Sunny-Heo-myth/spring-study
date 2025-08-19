package org.alan.toby.chapterone.connection;

import org.alan.toby.chapterone.connection.properties.ConnectionProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AlphaConnectionMaker implements ConnectionMaker {

    private final ConnectionProperties properties;

    public AlphaConnectionMaker(ConnectionProperties properties) {
        this.properties = properties;
    }

    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        Class.forName(properties.driver());
        return DriverManager.getConnection(properties.resource(), properties.user(), properties.password());
    }
}
