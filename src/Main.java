class Main {
    static class MyArraySizeException extends Exception {}

    public static void main(String[] args) {
        ArrExeption();
    }

    public static void ArrExeption() {
        int[][] arr = new int[4][4];
        try {
            if (arr.length > 4 | arr.length < 4) {}
        }
        catch (MyArraySizeException e) {
            System.out.println(e);
        }
    }

}