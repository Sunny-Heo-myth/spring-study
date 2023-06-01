package org.alan.spring.toby.dao;

import org.alan.spring.toby.domain.query.UserQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * How can I connect with db?
 * Just give connection.
 */
public class BetaUserDao extends UserDao {

    public BetaUserDao(UserQuery userQuery) {
        super(userQuery);
    }

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection c = DriverManager.getConnection("jdbc:oracle://localhost/toby", "root", "");
        return c;
    }
}
