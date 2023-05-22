package org.alan.javabasic.learningexception;

public class ExceptionMain1 {

    public static void main(String[] args) {
        System.out.println("main called.");
        ExceptionMain1 exceptionMain1 = new ExceptionMain1();
        exceptionMain1.methodA();
    }

    private void methodA() {
        System.out.println("methodA called.");
        methodB();
    }

    private void methodB() {
        try {
            System.out.println("methodB called.");
            methodC();
        } catch (ExceptionC c) {
            System.out.println("ExceptionC caught.");
            String b = "ExceptionB is thrown by methodB!";
            throw new ExceptionB(b);
        }
    }

    private void methodC() throws ExceptionC {
        System.out.println("methodC called.");
        String c = "ExceptionC is thrown by methodC!";
        throw new ExceptionC(c);
    }
}
