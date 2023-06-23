package org.alan.spring.toby.chapterone.connection.properties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public record ConnectionProperties(String driver, String resource, String user, String password) {
}
