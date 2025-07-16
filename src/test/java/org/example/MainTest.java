package org.example;

import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void testNumberFactorial() {
        assertEquals(1, Main.numberFactorial(0));
        assertEquals(1, Main.numberFactorial(1));
        assertEquals(120, Main.numberFactorial(5));
    }

    @Test
    public void testTriangleArea() {
        assertEquals(10, Main.triangleArea(5, 4));
        assertEquals(0, Main.triangleArea(0, 4));
        assertEquals(0, Main.triangleArea(5, 0));
    }

    @Test
    public void testArithmeticOperations() {
        Map<String, Integer> result = Main.arithmeticOperations(10, 2);
        assertEquals(12, result.get("addition"));
        assertEquals(8, result.get("subtraction"));
        assertEquals(20, result.get("multiplication"));
        assertEquals(5, result.get("division"));
    }

    @Test
    public void testNumbersComparison() {
        assertEquals(-1, Main.numbersComparison(2, 5));
        assertEquals(0, Main.numbersComparison(5, 5));
        assertEquals(1, Main.numbersComparison(7, 2));
    }
}