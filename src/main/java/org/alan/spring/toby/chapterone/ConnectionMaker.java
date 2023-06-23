package org.alan.spring.toby.chapterone.expanddao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * interface between server and implementation.
 */
public interface ConnectionMaker {

    Connection makeConnection() throws ClassNotFoundException, SQLException;
}
