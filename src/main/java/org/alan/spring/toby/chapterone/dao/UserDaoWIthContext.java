package org.alan.spring.toby.chapterone.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import toby.connection.ConnectionMaker;
import toby.dao.factory.AlphaDaoFactory;
import toby.exampleDomain.User;
import toby.exampleDomain.query.UserQuery;

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
        // todo not sure since there is no @Bean on AlphaDaoFactory
        this.connectionMaker = applicationContext.getBean("createAlphaConnectionMaker", ConnectionMaker.class);
        this.userQuery = applicationContext.getBean("createAlphaUserQuery", UserQuery.class);
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
