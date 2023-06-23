package org.alan.spring.toby.chapterone.dao;

import toby.connection.ConnectionMaker;
import toby.dao.factory.AlphaDaoFactory;
import toby.exampleDomain.User;
import toby.exampleDomain.query.UserQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoWithAlphaFactory {

    private final ConnectionMaker connectionMaker;
    private final UserQuery userQuery;

    public UserDaoWithAlphaFactory() {
        AlphaDaoFactory alphaDaoFactory = new AlphaDaoFactory();
        this.connectionMaker = alphaDaoFactory.createAlphaConnectionMaker();
        this.userQuery = alphaDaoFactory.createAlphaUserQuery();
    }


    public void add(User user) throws SQLException, ClassNotFoundException {
        Connection connection = connectionMaker.makeConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(userQuery.INSERT);
        preparedStatement.setString(1, user.getId());
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3, user.getPassword());
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection connection = connectionMaker.makeConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(userQuery.FIND);
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
