package org.alan.spring.toby.dao;

import lombok.RequiredArgsConstructor;
import org.alan.spring.toby.connection.ConnectionMaker;
import org.alan.spring.toby.dao.factory.AlphaDaoFactory;
import org.alan.spring.toby.domain.User;
import org.alan.spring.toby.domain.query.UserQuery;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@RequiredArgsConstructor
public class UserDaoWIthContext {
    private final ConnectionMaker connectionMaker;
    private final UserQuery userQuery;

    public UserDaoWIthContext() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AlphaDaoFactory.class);
        this.connectionMaker = applicationContext.getBean("createConnectionMaker", ConnectionMaker.class);
        this.userQuery = applicationContext.getBean("createUserQuery", UserQuery.class);
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
