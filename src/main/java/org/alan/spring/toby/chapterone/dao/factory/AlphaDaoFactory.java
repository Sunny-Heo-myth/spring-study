package org.alan.spring.toby.chapterone.dao.factory;

import lombok.NoArgsConstructor;
import org.alan.spring.toby.chapterone.connection.AlphaConnectionMaker;
import org.alan.spring.toby.chapterone.connection.ConnectionMaker;
import org.alan.spring.toby.chapterone.connection.properties.ConnectionProperties;
import org.alan.spring.toby.chapterone.dao.UserDaoWithException;
import org.alan.spring.toby.chapterone.exampleDomain.query.AlphaUserQueryImpl;
import org.alan.spring.toby.chapterone.exampleDomain.query.UserQuery;

@NoArgsConstructor
public class AlphaDaoFactory {

    private final ConnectionProperties alphaConnectionProperties = new ConnectionProperties(
            "com.mysql.jdbc.driver",
            "jdbc:mysql://localhost/toby",
            "hsymyth",
            "gjDHD1992"
    );

    public UserQuery createAlphaUserQuery() {
        return new AlphaUserQueryImpl();
    }

    public ConnectionMaker createAlphaConnectionMaker() {
        return new AlphaConnectionMaker(alphaConnectionProperties);
    }

    public UserDaoWithException createUserDao() {
        ConnectionMaker connectionMaker = createAlphaConnectionMaker();
        return new UserDaoWithException(connectionMaker, createAlphaUserQuery());
    }


}
