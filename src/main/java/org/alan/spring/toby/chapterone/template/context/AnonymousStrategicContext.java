package org.alan.spring.toby.chapterone.template.context;

import org.alan.spring.toby.chapterone.connection.ConnectionMaker;
import org.alan.spring.toby.chapterone.exampleDomain.User;
import org.alan.spring.toby.chapterone.exampleDomain.query.UserQuery;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AnonymousStrategicContext extends AbstractContext{

    public AnonymousStrategicContext(ConnectionMaker connectionMaker, UserQuery userQuery) {
        super(connectionMaker, userQuery);
    }

    @Override
    public void add(User user) throws SQLException, ClassNotFoundException {
        createStatementStrategy(
                connection -> {
                    PreparedStatement statement = connection.prepareStatement(userQuery.INSERT);
                    statement.setString(1, user.getId());
                    statement.setString(2, user.getName());
                    statement.setString(3, user.getPassword());
                    return statement;
                }
        );
    }

    @Override
    public void deleteAll() throws SQLException, ClassNotFoundException {
        createStatementStrategy(
                connection -> connection.prepareStatement(userQuery.DELETE_ALL)
        );
    }

}
