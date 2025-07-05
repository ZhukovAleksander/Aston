public class ArrayIndex {
    public static void main(String[] args) {
        try{
            int[] arr = new int[2];
            int value = arr[-1];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds");
        }
    }
}
