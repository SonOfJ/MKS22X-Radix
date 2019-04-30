public class Driver {
  public static void main(String[] args) {
    int[] array = {-2, 3, 3, 5, 7, -2, 0, -5, -78, 100};
    System.out.println("Before: " + array);
    Radix.radixsort(array);
    System.out.println("After: " + array);
  }
}
