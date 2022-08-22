package toby.dao.factory;

import lombok.NoArgsConstructor;
import toby.connection.AlphaConnectionMaker;
import toby.connection.ConnectionMaker;
import toby.connection.ConnectionProperties;
import toby.dao.UserDao;
import toby.domain.query.AlphaUserQueryImpl;
import toby.domain.query.UserQuery;

@NoArgsConstructor
public class AlphaDaoFactory {

    private ConnectionProperties defaultConnectionProperties = new ConnectionProperties(
            "com.mysql.jdbc.driver",
            "jdbc:mysql://localhost/toby",
            "hsymyth",
            "gjDHD1992"
    );
    public UserQuery createUserQuery() {
        return new AlphaUserQueryImpl();
    }

    public ConnectionMaker createConnectionMaker() {
        return new AlphaConnectionMaker(defaultConnectionProperties);
    }

    public UserDao createUserDao() {
        ConnectionMaker connectionMaker = createConnectionMaker();
        return new UserDao(connectionMaker, createUserQuery());
    }

}
