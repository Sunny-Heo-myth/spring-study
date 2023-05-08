package org.alan.spring.toby;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.alan.spring.toby.dao.UserDao;
import org.alan.spring.toby.dao.factory.AlphaDaoFactory;
import org.alan.spring.toby.domain.User;

import java.sql.SQLException;

@SpringBootApplication
public class TobyApp {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        AlphaDaoFactory alphaDaoFactory = new AlphaDaoFactory();

        UserDao dao = alphaDaoFactory.createUserDao();

        User user = new User("coca", "cola", "yummy");

        dao.add(user);
    }
}
