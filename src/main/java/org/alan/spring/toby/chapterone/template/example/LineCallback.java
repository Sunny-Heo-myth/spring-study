package org.alan.spring.toby.chapterone.template.example;

public interface LineCallback<T> {
    T executeLine(String line, T value);
}
