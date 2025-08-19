package org.alan.toby.chapterone.template.stretgy;

import lombok.RequiredArgsConstructor;
import org.alan.toby.chapterone.exampleDomain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@RequiredArgsConstructor
public class InsertStatementStrategy implements StatementStrategy{
    private final User user;
    @Override
    public PreparedStatement makePreparedStatement(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("insert into users(id, name, password) values (?,?,?)");
        statement.setString(1, user.getId());
        statement.setString(2, user.getName());
        statement.setString(3, user.getPassword());
        return statement;
    }
}
