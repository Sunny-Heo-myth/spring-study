package org.alan.toby.chapterone.template.context;

import org.alan.toby.chapterone.connection.ConnectionMaker;
import org.alan.toby.chapterone.template.stretgy.StatementStrategy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcContext {

    private final ConnectionMaker connectionMaker;

    public JdbcContext(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public void createStatement(final String query) throws SQLException, ClassNotFoundException {
        executeJdbcContextJob(
                new StatementStrategy() {
                    @Override
                    public PreparedStatement makePreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement statement = connection.prepareStatement(query);
                        return statement;
                    }
                }
        );
    }

    public void executeJdbcContextJob(StatementStrategy strategy) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = connectionMaker.makeConnection();
            preparedStatement = strategy.makePreparedStatement(connection);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw e;

        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw e;
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw e;
                }
            }

        }
    }
}
