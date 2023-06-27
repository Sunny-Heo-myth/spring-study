package org.alan.spring.toby.chapterone.template.stretgy;

import org.alan.spring.toby.chapterone.exampleDomain.query.UserQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteAllUserDaoStrategy extends AbstractUserDaoStrategy {

    public DeleteAllUserDaoStrategy(UserQuery userQuery) {
        super(userQuery);
    }

    @Override
    protected PreparedStatement makeStatement(Connection c) throws SQLException {
        return c.prepareStatement(userQuery.DELETE_ALL);
    }

}
