package org.alan.spring.toby.chapterone.expanddao;

import lombok.RequiredArgsConstructor;
import org.alan.spring.toby.chapterone.domain.User;
import org.alan.spring.toby.chapterone.domain.query.UserQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Server(context) provides general operation with interface.
 */
@RequiredArgsConstructor
public class UserDao {

    private final ConnectionMaker connectionMaker;
    private final UserQuery userQuery;

    public void add(User user) throws SQLException, ClassNotFoundException {
        Connection c = getConnection();

        String INSERT_USER = userQuery.INSERT;
        PreparedStatement ps = c.prepareStatement(INSERT_USER);
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection c = getConnection();

        String GET_USER = userQuery.FIND;
        PreparedStatement ps = c.prepareStatement(GET_USER);
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();

        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        return connectionMaker.makeConnection();
    }
}
