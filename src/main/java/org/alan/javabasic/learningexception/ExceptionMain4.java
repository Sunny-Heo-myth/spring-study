package org.alan.javabasic.learningexception;

public class ExceptionMain4 {

    public static void main(String[] args) {
        String runtimeExceptionMessage;
        try {
            System.out.println("main method called.");
            ExceptionMain4 exceptionMain4 = new ExceptionMain4();
            exceptionMain4.methodA();
        } catch (ExceptionA exceptionA) {
            System.out.println("ExceptionA caught by main.");
            runtimeExceptionMessage = "RuntimeException1 is thrown by main method.";
            throw new RuntimeException(runtimeExceptionMessage, exceptionA);
        } catch (NullPointerException nullPointerException) {
            System.out.println("NullPointerException caught by main.");
            runtimeExceptionMessage = "RuntimeException2 is thrown by main method.";
            throw new RuntimeException(runtimeExceptionMessage, nullPointerException);
        }

    }

    private void methodA() {
        try {
            System.out.println("methodA called.");
            methodB();
            System.out.println("Program ended.");

        } catch (ExceptionB exceptionB) {
            System.out.println("ExceptionB caught by methodA.");
            String exceptionAMessage = "ExceptionA is thrown by methodA!";
            throw new ExceptionA(exceptionAMessage, exceptionB);
        }

    }

    private void methodB() {
        try {
            System.out.println("methodB called.");
            methodC();

        } catch (ExceptionC exceptionC) {
            System.out.println("ExceptionC caught by methodB.");
            String exceptionBMessage = "ExceptionB is thrown by methodB!";
            throw new ExceptionB(exceptionBMessage, exceptionC);
        }
    }

    private void methodC() {
        System.out.println("methodC called.");
        methodNullPointer();
    }

    private void methodNullPointer() {
        System.out.println("methodNullPointer called.");
        String nullPointer = null;
        String upper = nullPointer.toUpperCase();
    }

}
