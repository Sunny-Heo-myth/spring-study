package org.alan.spring.toby.connection;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;

@RequiredArgsConstructor
@Getter
public class CountingConnectionMaker implements ConnectionMaker {
    private int counter = 0;
    private final ConnectionMaker connectionMaker;

    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        this.counter++;
        return connectionMaker.makeConnection();
    }
}
