package toby.connection;

import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@RequiredArgsConstructor
public class AlphaConnectionMaker implements ConnectionMaker{

    private final ConnectionProperties properties;

    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        Class.forName(properties.getDriver());
        return DriverManager.getConnection(properties.getResource(), properties.getUser(), properties.getPassword());
    }
}
