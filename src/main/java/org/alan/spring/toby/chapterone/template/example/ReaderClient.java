package org.alan.spring.toby.chapterone.template.example;

import java.io.IOException;

public class ReaderClient {

    public Integer fileCalcSum(String filePath) throws IOException {
        BufferedReaderCallback<Integer> sumCallBack = reader -> {
            int sum = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                sum += Integer.parseInt(line);
            }
            return sum;
        };
        return ReaderUtil.fileReadTemplate(filePath, sumCallBack);
    }

    public Integer fileCalcMultiple(String filePath) throws IOException {
        BufferedReaderCallback<Integer> multipleCallback = reader -> {
            int result = 1;
            String line;
            while ((line = reader.readLine()) != null) {
                int number = Integer.parseInt(line);
                if (number == 0) {
                    return 0;
                }
                result *= number;
            }
            return result;
        };
        return ReaderUtil.fileReadTemplate(filePath, multipleCallback);
    }

    public Integer lineCalcSum(String filePath) throws IOException {
        return ReaderUtil.lineReadTemplate(
                filePath,
                (line, value) -> value + Integer.parseInt(line),
                0
        );
    }

    public Integer lineCalcMultiple(String filePath) throws IOException {
        return ReaderUtil.lineReadTemplate(
                filePath,
                (line, value) -> value * Integer.parseInt(line),
                1
        );
    }
}
