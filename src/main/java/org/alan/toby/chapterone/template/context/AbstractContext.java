package org.alan.toby.chapterone.template.context;

import org.alan.toby.chapterone.connection.ConnectionMaker;
import org.alan.toby.chapterone.exampleDomain.User;
import org.alan.toby.chapterone.exampleDomain.query.UserQuery;
import org.alan.toby.chapterone.template.stretgy.StatementStrategy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class AbstractContext {
    protected final ConnectionMaker connectionMaker;
    protected final UserQuery userQuery;

    protected AbstractContext(ConnectionMaker connectionMaker, UserQuery userQuery) {
        this.connectionMaker = connectionMaker;
        this.userQuery = userQuery;
    }

    public abstract void add(User user) throws SQLException, ClassNotFoundException ;
    public abstract void deleteAll() throws SQLException, ClassNotFoundException ;

    protected void createStatementStrategy(StatementStrategy strategy) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = connectionMaker.makeConnection();
            statement = strategy.makePreparedStatement(connection);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw e;

        } finally {
            // Closing preparedStatement process.
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
            // Closing connection process.
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                }
            }
        }

    }
}
