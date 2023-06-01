package org.alan.spring.toby.dao;

import org.alan.spring.toby.domain.query.UserQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * How can I connect with db?
 * Just give connection.
 */
public class AlphaUserDao extends UserDao {

    public AlphaUserDao(UserQuery userQuery) {
        super(userQuery);
    }

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/toby", "root", "");
        return c;
    }
}
