package org.alan.toby.chapterone.template.stretgy;

import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@RequiredArgsConstructor
public class GetStatementStrategy implements StatementStrategy{

    private final String id;

    @Override
    public PreparedStatement makePreparedStatement(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("select * from users where id = ?");
        statement.setString(1, id);
        return statement;
    }
}
