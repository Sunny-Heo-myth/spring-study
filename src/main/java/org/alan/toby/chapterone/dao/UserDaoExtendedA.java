package org.alan.toby.chapterone.dao;

import org.alan.toby.chapterone.connection.ConnectionMaker;
import org.alan.toby.chapterone.exampleDomain.query.UserQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDaoExtendedA extends UserDaoWithException {

    public UserDaoExtendedA(ConnectionMaker connectionMaker, UserQuery userQuery) {
        super(connectionMaker, userQuery);
    }

    public Connection connect(String driver, String url, String user, String password) throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        return DriverManager.getConnection(url, user, password);
    }
}
