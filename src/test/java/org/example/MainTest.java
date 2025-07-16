package org.example;

import org.testng.annotations.*;
import static org.testng.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

public class MainTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeMethod
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterMethod
    public void restoreStreams() {
        System.setOut(originalOut);
        outContent.reset();
    }

    @Test(groups = "factorial")
    public void factorialOfZeroShouldReturnOne() {
        int result = Main.numberFactorial(0);
        assertEquals(result, 1);
        assertTrue(outContent.toString().contains("Факториал числа 0 = 1"));
    }

    @Test(groups = "factorial")
    public void factorialOfOneShouldReturnOne() {
        int result = Main.numberFactorial(1);
        assertEquals(result, 1);
    }

    @Test(groups = "factorial")
    public void factorialOfFiveShouldReturn120() {
        int result = Main.numberFactorial(5);
        assertEquals(result, 120);
    }

    @DataProvider(name = "triangleData")
    public Object[][] provideTriangleData() {
        return new Object[][]{
                {5, 4, 10},
                {10, 2, 10},
                {0, 10, 0},
                {7, 3, 10}
        };
    }

    @Test(groups = "area", dataProvider = "triangleData")
    public void testTriangleAreaCalculation(int base, int height, int expected) {
        int result = Main.triangleArea(base, height);
        assertEquals(result, expected);
        assertTrue(outContent.toString().contains("Площадь треугольника = " + expected));
    }

    @Test(groups = "arithmetic")
    public void arithmeticOperationsWithNormalNumbers() {
        Map<String, Integer> results = Main.arithmeticOperations(6, 3);

        assertEquals(results.get("addition"), Integer.valueOf(9), "Сумма неверна");
        assertEquals(results.get("subtraction"), Integer.valueOf(3), "Разность неверна");
        assertEquals(results.get("multiplication"), Integer.valueOf(18), "Произведение неверно");
        assertEquals(results.get("division"), Integer.valueOf(2), "Частное неверно");

        assertTrue(outContent.toString().contains("Сумма чисел = 9"));
    }

    @Test(groups = "arithmetic")
    public void arithmeticOperationsWithDivisionByZero() {
        Map<String, Integer> results = Main.arithmeticOperations(5, 0);

        assertNull(results.get("division"));
        assertTrue(outContent.toString().contains("Деление чисел = null"));
    }

    @Test(groups = "arithmetic")
    public void arithmeticOperationsWithNegativeNumbers() {
        Map<String, Integer> results = Main.arithmeticOperations(-4, 2);

        assertEquals(results.get("addition"), Integer.valueOf(-2));
        assertEquals(results.get("multiplication"), Integer.valueOf(-8));
    }

    @DataProvider(name = "comparisonData")
    public Object[][] provideComparisonData() {
        return new Object[][]{
                {3, 5, -1, "3 меньше 5"},
                {5, 5, 0, "5 равно 5"},
                {7, 2, 1, "7 больше 2"},
                {-3, -1, -1, "-3 меньше -1"}
        };
    }

    @Test(groups = "comparison", dataProvider = "comparisonData")
    public void testNumbersComparison(int a, int b, int expectedResult, String expectedOutput) {
        int result = Main.numbersComparison(a, b);
        assertEquals(result, expectedResult);
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Starting TestNG tests for Main class");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("All TestNG tests completed");
    }
}