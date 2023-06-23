package org.alan.spring.toby.chapterone.template.example;

import java.io.BufferedReader;
import java.io.IOException;

public interface BufferedReaderCallback<T> {
    T bufferedReaderCallback(BufferedReader reader) throws IOException;
}
