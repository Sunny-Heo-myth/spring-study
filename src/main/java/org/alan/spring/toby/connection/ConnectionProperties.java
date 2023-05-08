package org.alan.spring.toby.connection;

import lombok.Getter;

@Getter
public record ConnectionProperties(String driver, String resource, String user, String password) {

}
