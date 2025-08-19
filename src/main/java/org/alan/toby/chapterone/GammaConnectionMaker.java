package org.alan.toby.chapterone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * implementation(strategy) of server's abstract operation
 */
public class GammaConnectionMaker implements ConnectionMaker {
    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/toby", "root", "");
        return c;
    }
}
