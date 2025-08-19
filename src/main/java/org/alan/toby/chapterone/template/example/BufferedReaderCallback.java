package org.alan.toby.chapterone.template.example;

import java.io.BufferedReader;
import java.io.IOException;

public interface BufferedReaderCallback<T> {
    T bufferedReaderCallback(BufferedReader reader) throws IOException;
}
