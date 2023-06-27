package org.alan.spring.toby.chapterone.template.context;

import org.alan.spring.toby.chapterone.connection.ConnectionMaker;
import org.alan.spring.toby.chapterone.exampleDomain.User;
import org.alan.spring.toby.chapterone.exampleDomain.query.UserQuery;
import org.alan.spring.toby.chapterone.template.stretgy.DeleteAllStatementStrategy;
import org.alan.spring.toby.chapterone.template.stretgy.GetStatementStrategy;
import org.alan.spring.toby.chapterone.template.stretgy.InsertUserDaoStrategy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StrategicContext {

    private final ConnectionMaker connectionMaker;
    private final UserQuery userQuery;

    public StrategicContext(ConnectionMaker connectionMaker, UserQuery userQuery) {
        this.connectionMaker = connectionMaker;
        this.userQuery = userQuery;
    }

    public void add(User user) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = connectionMaker.makeConnection();
            InsertUserDaoStrategy strategy = new InsertUserDaoStrategy(userQuery, user);
            preparedStatement = strategy.makeStatement(connection);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw e;

        } finally {
            // Closing preparedStatement.
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    // Catch exception when closing preparedStatement.
                }
            }

            // Closing connection.
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // Catch exception when closing connection.
                }
            }

        }
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = connectionMaker.makeConnection();
            preparedStatement = new GetStatementStrategy(id).makePreparedStatement(connection);
            resultSet = preparedStatement.executeQuery();

            User user = new User();
            user.setId(resultSet.getString("id"));
            user.setName(resultSet.getString("name"));
            user.setPassword(resultSet.getString("password"));

            return user;

        } catch (SQLException e) {
            throw e;

        } finally {
            // Closing resultSet.
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    // Catch exception when closing resultSet.
                }
            }

            // Closing preparedStatement.
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    // Catch exception when closing preparedStatement.
                }
            }

            // Closing connection.
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // Catch exception when closing connection.
                }
            }

        }
    }

    public void deleteALl() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
           connection = connectionMaker.makeConnection();
           preparedStatement = new DeleteAllStatementStrategy().makePreparedStatement(connection);
           preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw e;

        } finally {
            // Closing preparedStatement.
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    // Catch exception when closing preparedStatement.
                }
            }

            // Closing connection.
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // Catch exception when closing connection.
                }
            }

        }
    }

}
