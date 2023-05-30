package org.alan.javabasic.learningexception;

public class ExceptionMain4 {

    public static void main(String[] args) {
        String runtimeExceptionDetailMessage = makeThrownMessage(RuntimeException.class, "main");

        try {
            System.out.println("main method called.");
            ExceptionMain4 exceptionMain4 = new ExceptionMain4();
            exceptionMain4.methodA();
            System.out.println("Program ended.");
        }

        catch (ExceptionA exceptionA) {
            System.err.println(makeCaughtMessage(ExceptionA.class, "main"));
            throw new RuntimeException(runtimeExceptionDetailMessage, exceptionA);
        }

        catch (ExceptionB exceptionB) {
            System.err.println(makeCaughtMessage(ExceptionB.class, "main"));
            throw new RuntimeException(runtimeExceptionDetailMessage, exceptionB);
        }

        catch (ExceptionC exceptionC) {
            System.err.println(makeCaughtMessage(ExceptionC.class, "main"));
            throw new RuntimeException(runtimeExceptionDetailMessage, exceptionC);
        }

        catch (NullPointerException nullPointerException) {
            System.err.println(makeCaughtMessage(NullPointerException.class, "main"));
            throw new RuntimeException(runtimeExceptionDetailMessage, nullPointerException);
        }

    }

    private void methodA() {
        String methodA = "methodA";
        String exceptionADetailMessage = makeThrownMessage(ExceptionA.class, methodA);

        try {
            System.out.println("methodA called.");
            methodB();
        }

        catch (ExceptionB exceptionB) {
            System.err.println(makeCaughtMessage(ExceptionB.class, methodA));
            throw new ExceptionA(exceptionADetailMessage, exceptionB);
        }

        catch (ExceptionC exceptionC) {
            System.err.println(makeCaughtMessage(ExceptionC.class, methodA));
            throw new ExceptionA(exceptionADetailMessage, exceptionC);
        }

        catch (NullPointerException nullPointerException) {
            System.err.println(makeCaughtMessage(NullPointerException.class, methodA));
            throw new ExceptionA(exceptionADetailMessage, nullPointerException);
        }

    }

    private void methodB() {
        String methodB = "methodB";
        String exceptionBDetailMessage = makeThrownMessage(ExceptionB.class, methodB);

        try {
            System.out.println("methodB called.");
            methodC();
        }

        catch (ExceptionC exceptionC) {
            System.err.println(makeCaughtMessage(ExceptionC.class, methodB));
            throw new ExceptionB(exceptionBDetailMessage, exceptionC);
        }

        catch (NullPointerException nullPointerException) {
            System.err.println(makeCaughtMessage(NullPointerException.class, methodB));
            throw new ExceptionB(exceptionBDetailMessage, nullPointerException);
        }
    }

    private void methodC() {
        String methodC = "methodC";
        String exceptionCDetailMessage = makeThrownMessage(ExceptionC.class, methodC);

        try {
            System.out.println("methodC called.");
            methodNullPointer();
        }

        catch (NullPointerException nullPointerException) {
            System.err.println(makeCaughtMessage(NullPointerException.class, methodC));
            throw new ExceptionC(exceptionCDetailMessage, nullPointerException);
        }
    }

    private void methodNullPointer() {
        System.out.println("methodNullPointer called.");
        String nullPointer = null;
        String upper = nullPointer.toUpperCase();
    }

    private static String makeThrownMessage(Class<?> exceptionName, String by) {
        return exceptionName + " is thrown by " + by + ".";
    }

    private static String makeCaughtMessage(Class<?> exceptionName, String by) {
        return exceptionName + " is caught by " + by + ".";
    }

}
