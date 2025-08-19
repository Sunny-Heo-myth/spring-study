package org.alan.toby.chapterone.template.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderUtil {
    public static Integer fileReadTemplate(String filePath, BufferedReaderCallback<Integer> callback) throws IOException {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(filePath));
            return callback.bufferedReaderCallback(reader);

        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw e;

        } finally {
            if (reader != null) {
                try {
                    reader.close();

                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

    }

    public static Integer lineReadTemplate(String filePath, LineCallback<Integer> callback, int init) throws IOException {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            Integer result = init;
            String line;
            while ((line = reader.readLine()) != null) {
                result = callback.executeLine(line, result);
            }
            return result;

        } catch (IOException ignored) {
        } finally {
        }
        return null;
    }
}
