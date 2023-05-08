package org.alan.javabasic;

public class StringCalculator {

    public int stringCalculator(String s) {
        char[] chars = s.toCharArray();
        return chars[0] == '\\' ? adder(chars, 3) : adder(chars, 0);
    }

    public int adder(char[] chars, int startingIndex) {
        int result = 0;
        for (int i = startingIndex; i < chars.length; i += 2) {
            result += toInt(chars[i]);
        }
        return result;
    }

    public int toInt(char c) {
        int i = c != ' ' ? Character.getNumericValue(c) : 0;
        if (i < 0) {
            throw new RuntimeException();
        }
        return i;
    }
}
