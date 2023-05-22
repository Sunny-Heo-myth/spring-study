package org.alan.javabasic.learningexception;

public class ExceptionA extends RuntimeException {

    public ExceptionA(String message) {
        super(message);
    }

    public ExceptionA(String message, Throwable cause) {
        super(message, cause);
    }

}
