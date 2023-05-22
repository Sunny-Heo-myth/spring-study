package org.alan.javabasic.learningexception;

public class ExceptionMain2 {

    public static void main(String[] args) {
        ExceptionMain2 exceptionMain2 = new ExceptionMain2();
        exceptionMain2.methodA();
    }

    private void methodA() {
        try {
            System.out.println("methodA called.");
            methodB();
            System.out.println("Program ended.");

        } catch (ExceptionB b) {
            String a = "ExceptionB is thrown by methodB!";
            throw new ExceptionA(a);
        }

    }

    private void methodB() throws ExceptionB {
        try {
            System.out.println("methodB called.");
            methodC();

        } catch (ExceptionC c) {
            System.out.println("ExceptionC caught.");
            String a = "ExceptionA is thrown by methodB!";
            throw new ExceptionA(a);
        }
    }

    private void methodC() throws ExceptionC {
        System.out.println("methodC called.");
        String c = "ExceptionC is thrown by methodC!";
        throw new ExceptionC(c);
    }

}
