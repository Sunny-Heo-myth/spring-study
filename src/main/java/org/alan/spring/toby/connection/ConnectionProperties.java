package org.alan.spring.toby.connection;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ConnectionProperties {

    private final String driver;
    private final String resource;
    private final String user;
    private final String password;

}
