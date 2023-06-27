package org.alan.spring.toby.chapterone.template.client;

import org.alan.spring.toby.chapterone.connection.ConnectionMaker;
import org.alan.spring.toby.chapterone.exampleDomain.User;
import org.alan.spring.toby.chapterone.exampleDomain.query.UserQuery;
import org.alan.spring.toby.chapterone.template.context.JdbcContext;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDaoAsClient {
    private final JdbcContext context;
    private final UserQuery query;
    private final ConnectionMaker connectionMaker;

    // UserClient initialize variables with certain object in runtime.
    public UserDaoAsClient(ConnectionMaker connectionMaker, UserQuery query) {
        this.context = new JdbcContext(connectionMaker);
        this.query = query;
        // Save connectionMaker for the method which has not been used.
        this.connectionMaker = connectionMaker;
    }

    public void add(final User user) throws SQLException, ClassNotFoundException {
        this.context.executeJdbcContextJob(
                connection -> {
                    PreparedStatement statement = connection.prepareStatement(query.INSERT);
                    statement.setString(1, user.getId());
                    statement.setString(2, user.getName());
                    statement.setString(3, user.getPassword());
                    return statement;
                }
        );
    }

    public void deleteAll() throws SQLException, ClassNotFoundException {
        context.createStatement(query.DELETE_ALL);
    }
}
