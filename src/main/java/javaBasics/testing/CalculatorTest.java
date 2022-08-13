package javaBasics.testing;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println(calculator.add(1, 2));
        System.out.println(calculator.subtract(4, 6));
        System.out.println(calculator.multiply(2, 9));
        System.out.println(calculator.divide(6, 2));
    }
}
