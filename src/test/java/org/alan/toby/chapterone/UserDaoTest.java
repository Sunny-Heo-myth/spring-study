package org.alan.toby.chapterone;

import org.alan.toby.chapterone.domain.User;
import org.alan.toby.chapterone.domain.query.AlphaUserQueryImpl;
import org.alan.toby.chapterone.domain.query.UserQuery;

import java.sql.SQLException;

/**
 * Client choose the implementation of server.
 */
public class UserDaoTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserQuery userQuery = new AlphaUserQueryImpl();
        ConnectionMaker connectionMaker = new GammaConnectionMaker();

        UserDao dao = new UserDao(connectionMaker, userQuery);

        User user1 = new User("id", "name", "pw");
        dao.add(user1);
        System.out.println(user1.getId() + " add success!");

        User user2 = dao.get("id");
        System.out.println(user2.getId() + " get success!");
    }
}
