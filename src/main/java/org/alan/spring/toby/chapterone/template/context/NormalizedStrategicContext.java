package org.alan.spring.toby.chapterone.template.context;

import org.alan.spring.toby.chapterone.connection.ConnectionMaker;
import org.alan.spring.toby.chapterone.exampleDomain.User;
import org.alan.spring.toby.chapterone.template.stretgy.DeleteAllStatementStrategy;
import org.alan.spring.toby.chapterone.template.stretgy.GetStatementStrategy;
import org.alan.spring.toby.chapterone.template.stretgy.InsertStatementStrategy;
import org.alan.spring.toby.chapterone.template.stretgy.StatementStrategy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NormalizedStrategicContext {
    private final ConnectionMaker connectionMaker;

    public NormalizedStrategicContext(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public void add(User user) throws SQLException, ClassNotFoundException {
        // strategy
        StatementStrategy strategy = new InsertStatementStrategy(user);
        // template
        createStatementStrategy(strategy);
    }

    public void deleteAll() throws SQLException, ClassNotFoundException {
        // strategy
        StatementStrategy strategy = new DeleteAllStatementStrategy();
        // template
        createStatementStrategy(strategy);
    }

    public User get(String id) throws SQLException, ClassNotFoundException {
        // strategy
        StatementStrategy strategy = new GetStatementStrategy(id);
        // template
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = connectionMaker.makeConnection();
            statement = strategy.makePreparedStatement(connection);
            resultSet = statement.executeQuery();

            User user = new User();
            user.setId(resultSet.getString("id"));
            user.setName(resultSet.getString("name"));
            user.setPassword(resultSet.getString("password"));

            return user;

        } catch (SQLException e) {
            throw e;

        } finally {

            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    // Catch exception when closing resultSet.
                }
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                }
            }
        }

    }

    private void createStatementStrategy(StatementStrategy strategy) throws SQLException, ClassNotFoundException {
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
