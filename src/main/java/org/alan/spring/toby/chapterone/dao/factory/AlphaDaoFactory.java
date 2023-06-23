package org.alan.spring.toby.chapterone.dao.factory;

import lombok.NoArgsConstructor;
import toby.connection.AlphaConnectionMaker;
import toby.connection.ConnectionMaker;
import toby.connection.properties.ConnectionProperties;
import toby.dao.UserDaoWithException;
import toby.exampleDomain.query.AlphaUserQueryImpl;
import toby.exampleDomain.query.UserQuery;

@NoArgsConstructor
public class AlphaDaoFactory {

    private ConnectionProperties alphaConnectionProperties = new ConnectionProperties(
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
