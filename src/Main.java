class Main {
    static class MyArraySizeException extends Exception {
        public String exeptionMessage() {
            return "Размер должен быть 4 на 4";
        }
    }

    static class MyArrayDataException extends Exception {
        private final int a;
        private final int b;

        public MyArrayDataException(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public String exeptionMessage() {
            return "Неправильный формат данных в ячейке [" + a + "] [" + b + "]";
        }
    }

    public static void main(String[] args) {
        // Тестовые массивы
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] sizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        String[][] dataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11a", "12"},
                {"13", "14", "15", "16"}
        };

        System.out.println("Правильный массив: ");
        processArray(correctArray);

        System.out.println("\nНеправильный размер массива: ");
        processArray(sizeArray);

        System.out.println("\nНеправильный формат данных в массиве: :");
        processArray(dataArray);
    }

    private static void processArray(String[][] array) {
        try {
            int sum = ArrExeption(array);
            System.out.println("Sum of elements: " + sum);
        } catch (MyArraySizeException e) {
            System.out.println("Error: " + e.exeptionMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Error: " + e.exeptionMessage());
        }
    }

    public static int ArrExeption(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (String[] a : arr) {
            if (a.length != 4) {
                throw new MyArraySizeException();
            }
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}