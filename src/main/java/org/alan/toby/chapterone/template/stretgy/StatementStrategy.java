package org.alan.toby.chapterone.template.stretgy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface StatementStrategy {

    PreparedStatement makePreparedStatement(Connection connection) throws SQLException;

}
