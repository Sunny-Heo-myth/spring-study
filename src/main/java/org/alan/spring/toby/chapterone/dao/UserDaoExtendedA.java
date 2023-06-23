package org.alan.spring.toby.chapterone.dao;

import toby.connection.ConnectionMaker;
import toby.exampleDomain.query.UserQuery;

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
