package javaBasics.testing;

import org.alan.javaBasics.StringCalculator;
import org.alan.javaBasics.testing.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculateTest {
    Calculator cal;
    StringCalculator stringCalculator;

    @BeforeEach
    public void setup() {
        cal = new Calculator();
        stringCalculator = new StringCalculator();
        System.out.println("before");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("tear down");
    }

    @Test
    public void add() {

        assertEquals(9, cal.add(6, 3));
    }

    @Test
    public void subtract() {
        assertEquals(3, cal.subtract(6, 3));
    }

    @Test
    public void multiply() {
        assertEquals(18, cal.multiply(6, 3));
    }

    @Test
    public void divide() {
        assertEquals(2, cal.divide(6, 3));
    }

    @Test
    public void stringCalculatorTest1() {
        assertEquals(6, stringCalculator.stringCalculator("1,2,3"));
    }
    @Test
    public void stringCalculatorTest2() {
        assertEquals(6, stringCalculator.stringCalculator("\\;\n1;2;3"));
    }

    @Test
    public void stringCalculatorTest3() {
        assertThrows(RuntimeException.class, () -> stringCalculator.stringCalculator("1;-1;3"));
    }

    @Test
    public void stringCalculatorTest4() {
        assertEquals(3, stringCalculator.stringCalculator("1;2"));
    }

    @Test
    public void stringCalculatorTest5() {
        assertEquals(0, stringCalculator.stringCalculator(" "));
    }

    @Test
    public void stringCalculatorTest6() {
        assertEquals(2, stringCalculator.stringCalculator("2"));
    }

}
