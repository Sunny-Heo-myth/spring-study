package org.alan.toby.chapterone.connection;

import lombok.Getter;

import java.sql.Connection;
import java.sql.SQLException;

@Getter
public class CountingConnectionMaker implements ConnectionMaker {
    private int counter = 0;
    private final ConnectionMaker connectionMaker;

    public CountingConnectionMaker(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        this.counter++;
        return connectionMaker.makeConnection();
    }
}
