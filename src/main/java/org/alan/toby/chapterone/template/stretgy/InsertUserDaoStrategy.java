package org.alan.toby.chapterone.template.stretgy;

import org.alan.toby.chapterone.exampleDomain.User;
import org.alan.toby.chapterone.exampleDomain.query.UserQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertUserDaoStrategy extends AbstractUserDaoStrategy{

    private final User user;

    public InsertUserDaoStrategy(UserQuery userQuery, User user) {
        super(userQuery);
        this.user = user;
    }

    @Override
    public PreparedStatement makeStatement(Connection c) throws SQLException {
        PreparedStatement statement = c.prepareStatement(userQuery.INSERT);
        statement.setString(1, user.getId());
        statement.setString(2, user.getName());
        statement.setString(3, user.getPassword());
        return statement;
    }

}
