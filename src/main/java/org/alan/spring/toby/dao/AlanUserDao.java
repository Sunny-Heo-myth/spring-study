package org.alan.spring.toby.dao;

import org.alan.spring.toby.domain.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlanUserDao {

    public void add(User user) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");

        // get connection
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/toby", "root", "");

        // get preparedStatement
        PreparedStatement ps = c.prepareStatement(
                "insert into users(id, name, password) values (?,?,?)"
        );

        // set parameters for preparedStatement.
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        // execute query
        ps.executeUpdate();

        // close resource
        ps.close();
        c.close();
    }

}
