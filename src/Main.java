import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign(1, 2);
        printColor(125);
        compareNumbers(8, 4);
        method5(7, 3);
        method6(-2);
        method7(13);
        method8("Aston", 3);
        method9(2025);
        method10();
        method11(100);
        method12();
        method13();
        method14(3, 0);
    }

    public static void printThreeWords() {
        System.out.println("1) Orange");
        System.out.println("1) Banana");
        System.out.println("1) Apple");
    }

    public static void checkSumSign(int a, int b) {
        if (a + b >= 0) {
            System.out.println("2) Сумма положительная");
        } else {
            System.out.println("2) Сумма отрицательная");
        }
    }

    public static void printColor(int value) {
        if (value <= 0) {
            System.out.println("3) Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("3) Желтый");
        } else {
            System.out.println("3) Зеленый");
        }
    }

    public static void compareNumbers(int a, int b) {
        if (a >= b) {
            System.out.println("4) " + a + " >= " + b);
        } else {
            System.out.println("4) " + a + "<" + b);
        }
    }

    public static boolean method5(int a, int b) {
        boolean result = (a + b > 10) && (a + b <= 20);
        System.out.println("5) " + result);
        return result;
    }

    public static void method6(int a) {
        if (a >= 0) {
            System.out.println("6) Положительное");
        } else {
            System.out.println("6) Отрицательное");
        }
    }

    public static void method7(int a) {
        boolean result = a < 0;
        System.out.println("7) " + result);
    }

    public static void method8(String string, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println("8) " + string);
        }
    }

    public static boolean method9(int year) {
        boolean leapYear = (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
        return leapYear;
    }

    public static void method10() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void method11(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i + 1;
        }
        System.out.println("11) " + Arrays.toString(arr));
    }

    public static void method12() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
    }

    public static void method13() {
        int[][] arr = new int[5][5];
        int secondaryIndex = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
            arr[i][secondaryIndex] = 1;
            secondaryIndex--;
        }
        //Arrays.stream(arr).forEach(row -> System.out.println(Arrays.toString(row)));
    }

    public static int[] method14(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }
}