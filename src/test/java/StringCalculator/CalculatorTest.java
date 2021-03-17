package StringCalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void addTestMethod(){
        Calculator calculator = new Calculator();
        assertEquals(1+2, calculator.add("1, 2"));




    }

}