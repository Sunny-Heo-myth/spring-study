package org.alan.spring.toby.dao;

import org.alan.spring.toby.connection.ConnectionMaker;
import org.alan.spring.toby.domain.query.UserQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BetaUserDao extends UserDao{

    public BetaUserDao(ConnectionMaker connectionMaker, UserQuery userQuery) {
        super(connectionMaker, userQuery);
    }

    public Connection connect(String driver, String url, String user, String password) throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        return DriverManager.getConnection(url, user, password);
    }
}
