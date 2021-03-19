package StringCalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void addMultipleNumbersTestMethod() {
        Calculator calculator = new Calculator();

        assertEquals(9, calculator.add("1, 2\n 2\n 4"));

    }

    @Test
    void addSingleNumberTestMethod() {
        Calculator calc = new Calculator();

        assertEquals(5, calc.add("5"));

    }

    @Test
    void specificDelimiterSeparatesNumbers() {
        Calculator calc = new Calculator();

        assertEquals(7, calc.add("//~~~\n1~~~3~~~3"));
    }
}
