package org.alan.spring.toby.dao;

import org.alan.spring.toby.connection.ConnectionMaker;
import org.alan.spring.toby.domain.User;
import org.alan.spring.toby.domain.query.AlphaUserQueryImpl;
import org.alan.spring.toby.domain.query.UserQuery;
import org.alan.spring.toby.dao.factory.AlphaDaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoWithFactory {
    private final ConnectionMaker connectionMaker;
    private final UserQuery userQuery;

    public UserDaoWithFactory() {
        AlphaDaoFactory factory = new AlphaDaoFactory();
        this.connectionMaker = factory.createConnectionMaker();
        this.userQuery = new AlphaUserQueryImpl();
    }


    public void add(User user) throws SQLException, ClassNotFoundException {
        Connection connection = connectionMaker.makeConnection();

        String INSERT_USER = userQuery.INSERT;
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);
        preparedStatement.setString(1, user.getId());
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3, user.getPassword());

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection connection = connectionMaker.makeConnection();

        String GET_USER = userQuery.FIND;
        PreparedStatement preparedStatement = connection.prepareStatement(GET_USER);
        preparedStatement.setString(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        User user = new User();
        user.setId(resultSet.getString("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return user;
    }
}
