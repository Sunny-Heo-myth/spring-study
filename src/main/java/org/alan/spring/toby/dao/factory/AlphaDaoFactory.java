package org.alan.spring.toby.dao.factory;

import lombok.NoArgsConstructor;
import org.alan.spring.toby.connection.AlphaConnectionMaker;
import org.alan.spring.toby.connection.ConnectionMaker;
import org.alan.spring.toby.connection.ConnectionProperties;
import org.alan.spring.toby.dao.UserDao;
import org.alan.spring.toby.domain.query.AlphaUserQueryImpl;
import org.alan.spring.toby.domain.query.UserQuery;

@NoArgsConstructor
public class AlphaDaoFactory {

    private final ConnectionProperties defaultConnectionProperties = new ConnectionProperties(
            "com.mysql.jdbc.driver"
            , "jdbc:mysql://localhost/toby"
            , "hsymyth"
            , "gjDHD1992"
    );
    public UserQuery createUserQuery() {
        return new AlphaUserQueryImpl();
    }

    public ConnectionMaker createConnectionMaker() {
        return new AlphaConnectionMaker(defaultConnectionProperties);
    }

    public UserDao createUserDao() {
        ConnectionMaker connectionMaker = createConnectionMaker();
        return null;
    }

}
