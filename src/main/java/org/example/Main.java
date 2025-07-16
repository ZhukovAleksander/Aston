package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        numberFactorial(5);
        triangleArea(5, 4);
        arithmeticOperations(3, 2);
        numbersComparison(5, 6);
    }

    public static int numberFactorial(int a) {
        int factorial = 1;
        for (int i = 1; i <= a; i++) {
            factorial *= i;
        }
        System.out.println("Факториал числа " + a + " = " + factorial);
        return factorial;
    }

    public static int triangleArea(int a, int h) {
        int S = (a * h) / 2;
        System.out.println("Площадь треугольника = " + S);
        return S;
    }

    public static Map<String, Integer> arithmeticOperations(int a, int b) {
        Map<String, Integer> results = new HashMap<>();
        results.put("addition", a + b);
        results.put("subtraction", a - b);
        results.put("multiplication", a * b);

        if (b != 0) {
            results.put("division", a / b);
        } else {
            results.put("division", null);
        }

        System.out.println("Сумма чисел = " + results.get("addition") +
                "\nРазница чисел = " + results.get("subtraction") +
                "\nУмножение чисел = " + results.get("multiplication") +
                "\nДеление чисел = " + results.get("division"));

        return results;
    }

    public static int numbersComparison(int a, int b) {
        int comparisonResult = Integer.compare(a, b);

        if (comparisonResult < 0) {
            System.out.println(a + " меньше " + b);
        } else if (comparisonResult == 0) {
            System.out.println(a + " равно " + b);
        } else {
            System.out.println(a + " больше " + b);
        }

        return comparisonResult;
    }
}