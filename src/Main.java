class Main {
    static class MyArraySizeException extends Exception {}
    static class MyArrayDataException extends Exception {
        public MyArrayDataException(int row, int col) {
            super("Error " + "[" + row + "] [" + col + "]");
        }
    }

    public static void main(String[] args) {
        String[][] testArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "1a", "15", "16"}
        };

        try {
            int sum = ArrExeption(testArray);
            System.out.println("Sum of array elements: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int ArrExeption(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (String[] row : arr) {
            if (row.length != 4) {
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