package org.alan.toby.chapterone.dao;

import org.alan.toby.chapterone.connection.ConnectionMaker;
import org.alan.toby.chapterone.exampleDomain.User;
import org.alan.toby.chapterone.exampleDomain.query.UserQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoWithException {

    // DB connection interface which will be initialized by a container.
    private final ConnectionMaker connectionMaker;
    // Query for this domain.
    private final UserQuery userQuery;

    public UserDaoWithException(ConnectionMaker connectionMaker, UserQuery userQuery) {
        this.connectionMaker = connectionMaker;
        this.userQuery = userQuery;
    }

    public void add(User user) throws SQLException, ClassNotFoundException {
        // Declare connection to a database & a preparedStatement for the connection.
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Initialize connection with a instance field initialized by a container.
            connection = connectionMaker.makeConnection();
            // Initialize preparedStatement with a local variable(connection) & a String field of this instance field.
            preparedStatement = connection.prepareStatement(userQuery.INSERT);

            // Add value for the preparedStatement.
            preparedStatement.setString(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw e;

        } finally {
            // Return all resources.

            // Try to close preparedStatement if it is not initialized as null.
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    // Catch exception when closing preparedStatement.
                }
            }

            // Try to close connection if it is not initialized as null.
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
        // Declare connection type for a DB & preparedStatement to send to the DB & resultSet for return from teh DB.
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Initialize connection & preparedStatement.
            connection = connectionMaker.makeConnection();
            preparedStatement = connection.prepareStatement(userQuery.FIND);
            preparedStatement.setString(1, id);
            // Execute query with the preparedStatement and initialize resultSet with the return value.
            resultSet = preparedStatement.executeQuery();

            // Declare & initialize & set instance field with the resultSet.
            User user = new User();
            user.setId(resultSet.getString("id"));
            user.setName(resultSet.getString("name"));
            user.setPassword(resultSet.getString("password"));
            return user;

        } catch (SQLException e) {
            throw e;

        } finally {
            // Return all resources.

            // Try to close resultSet if it is not initialized as null.
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    // Catch exception when closing resultSet.
                }
            }

            // Try to close preparedStatement if it is not initialized as null.
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    // Catch exception when closing preparedStatement.
                }
            }

            // Try to close connection if it is not initialized as null.
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
        // Declare connection & preparedStatement.
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = connectionMaker.makeConnection();
            preparedStatement = connection.prepareStatement(userQuery.DELETE_ALL);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw e;

        } finally {
            // Try to close preparedStatement if it is not initialized as null.
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    // Catch exception when closing preparedStatement.
                }
            }

            // Try to close connection if it is not initialized as null.
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
