package org.alan.javabasic.learningexception;

public class ExceptionMain3 {

    public static void main(String[] args) {
        try {
            System.out.println("main method called.");
            ExceptionMain3 exceptionMain3 = new ExceptionMain3();
            exceptionMain3.methodA();

        } catch (ExceptionA exceptionA) {
            System.out.println("ExceptionA caught by main.");
            String runtimeMessage = "RuntimeMessage is thrown by main method.";
            throw new RuntimeException(runtimeMessage, exceptionA);
        }

    }

    private void methodA() {
        try {
            System.out.println("methodA called.");
            methodB();
            System.out.println("Program ended.");

        } catch (ExceptionB exceptionB) {
            System.out.println("ExceptionB caught ny methodA.");
            String messageA = "ExceptionA is thrown by methodA!";
            throw new ExceptionA(messageA, exceptionB);
        }

    }

    private void methodB() {
        try {
            System.out.println("methodB called.");
            methodC();

        } catch (ExceptionC exceptionC) {
            System.out.println("ExceptionC caught by methodB.");
            String messageB = "ExceptionB is thrown by methodB!";
            throw new ExceptionB(messageB, exceptionC);
        }
    }

    private void methodC() {
        try {
            System.out.println("methodC called.");
            methodNullPointer();
        } catch (NullPointerException nullPointerException) {
            System.out.println("NullPointerException caught by methodC.");
            String messageC = "ExceptionC is thrown by methodC!";
            throw new ExceptionC(messageC, nullPointerException);
        }

    }

    private void methodNullPointer() {
        System.out.println("methodNullPointer called.");
        String nullPointer = null;
        String upper = nullPointer.toUpperCase();
    }

}
