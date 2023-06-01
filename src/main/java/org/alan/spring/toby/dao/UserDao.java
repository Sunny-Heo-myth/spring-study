package org.alan.spring.toby.dao;

import lombok.RequiredArgsConstructor;
import org.alan.spring.toby.domain.User;
import org.alan.spring.toby.domain.query.AlphaUserQueryImpl;
import org.alan.spring.toby.domain.query.UserQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * What kind of interaction are there between db?
 * Just use connection.
 */
@RequiredArgsConstructor
public abstract class UserDao {

    private final UserQuery userQuery;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserQuery userQuery = new AlphaUserQueryImpl();
        UserDao dao = new AlphaUserDao(userQuery);
//        UserDao dao = new BetaUserDao(userQuery);

        User user1 = new User("id", "name", "pw");
        dao.add(user1);
        System.out.println(user1.getId() + " add success!");

        User user2 = dao.get("id");
        System.out.println(user2.getId() + " get success!");
    }

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

    public abstract Connection getConnection() throws ClassNotFoundException, SQLException;

}
