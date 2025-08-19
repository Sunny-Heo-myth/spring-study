package org.alan.toby.chapterone.template.context;

import org.alan.toby.chapterone.connection.ConnectionMaker;
import org.alan.toby.chapterone.exampleDomain.User;
import org.alan.toby.chapterone.exampleDomain.query.UserQuery;
import org.alan.toby.chapterone.template.stretgy.StatementStrategy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LocalClassedContext extends AbstractContext{

    public LocalClassedContext(ConnectionMaker connectionMaker, UserQuery userQuery) {
        super(connectionMaker, userQuery);
    }

    @Override
    public void add(User user) throws SQLException, ClassNotFoundException {
        // strategy local class
        class AddStatement implements StatementStrategy {
            private final User user;

            AddStatement(User user) {
                this.user = user;
            }

            @Override
            public PreparedStatement makePreparedStatement(Connection connection) throws SQLException {
                PreparedStatement statement = connection.prepareStatement(userQuery.INSERT);
                statement.setString(1, user.getId());
                statement.setString(2, user.getName());
                statement.setString(3, user.getPassword());
                return statement;
            }
        }

        createStatementStrategy(new AddStatement(user));
    }

    @Override
    public void deleteAll() throws SQLException, ClassNotFoundException {
        // strategy local class
        class DeleteAllStatement implements StatementStrategy {

            @Override
            public PreparedStatement makePreparedStatement(Connection connection) throws SQLException {
                return connection.prepareStatement(userQuery.DELETE_ALL);
            }
        }

        createStatementStrategy(new DeleteAllStatement());
    }
}
