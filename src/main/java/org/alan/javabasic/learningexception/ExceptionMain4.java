package org.alan.javabasic.learningexception;

public class ExceptionMain4 {

    public static void main(String[] args) {
        String runtimeExceptionMessage = "RuntimeException is thrown by main method.";
        try {
            System.out.println("main method called.");
            ExceptionMain4 exceptionMain4 = new ExceptionMain4();
            exceptionMain4.methodA();
            System.out.println("Program ended.");
        }

//        catch (ExceptionA exceptionA) {
//            System.err.println("ExceptionA caught by main.");
//            throw new RuntimeException(runtimeExceptionMessage, exceptionA);
//        }

        catch (ExceptionB exceptionB) {
            System.err.println("ExceptionB caught by main.");
            throw new RuntimeException(runtimeExceptionMessage, exceptionB);
        }

//        catch (NullPointerException nullPointerException) {
//            System.err.println("NullPointerException caught by main.");
//            runtimeExceptionMessage = "RuntimeException is thrown by main method.";
//            throw new RuntimeException(runtimeExceptionMessage, nullPointerException);
//        }

    }

    private void methodA() {
        try {
            System.out.println("methodA called.");
            methodB();
        }

        catch (ExceptionB exceptionB) {
            System.err.println("ExceptionB caught by methodA.");
            String exceptionAMessage = "ExceptionA is thrown by methodA!";
            throw new ExceptionA(exceptionAMessage, exceptionB);
        }

        catch (NullPointerException e) {
            System.err.println("NullPointerException caught by methodA.");
            String exceptionAMessage = "ExceptionA is thrown by methodA.";
            throw new ExceptionA(exceptionAMessage);
        }

    }

    private void methodB() {
        try {
            System.out.println("methodB called.");
            methodC();
        }

        catch (ExceptionC exceptionC) {
            System.err.println("ExceptionC caught by methodB.");
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
