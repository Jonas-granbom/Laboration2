package StringCalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void addMultipleNumbersTestMethod() {
        Calculator calculator = new Calculator();

        assertEquals(1 + 2 + 2 + 4, calculator.add("1, 2, 2, 4"));

    }

    @Test
    void addSingleNumberTestMethod() {
        Calculator calc = new Calculator();

        assertEquals(5, calc.add("5"));

    }

}