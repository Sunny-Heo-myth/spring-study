package org.alan.spring.toby.chapterone.template.stretgy;

import lombok.RequiredArgsConstructor;
import org.alan.spring.toby.chapterone.exampleDomain.query.UserQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@RequiredArgsConstructor
public abstract class AbstractUserDaoStrategy {

    protected final UserQuery userQuery;

    abstract protected PreparedStatement makeStatement(Connection c) throws SQLException;

}
