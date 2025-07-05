class Main {
    static class MyArraySizeException extends Exception {}

    public static void main(String[] args) {
        ArrExeption(4, 4);
    }

    public static void ArrExeption(int a, int b) {
        int[][] arr = new int[a][b];
        try {
            if (arr.length != 4) {
                throw new MyArraySizeException();
            }
            for (int[] row : arr) {
                if (row.length != 4) {
                    throw new MyArraySizeException();
                }
            }
        }
        catch (MyArraySizeException e) {
            System.out.println(e);
        }
    }
}