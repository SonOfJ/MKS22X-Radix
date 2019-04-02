public class Radix {
  public static void radixsort(int[] data) {
    int max = data[0]; //Variable that points to the highest value in a list.
    for (int i = 0; i < data.length; i = i + 1) { //Find the max value.
      if (data[i] > max) {
        max = data[i];
      }
    }
    for (int i = 1; max / i > 0; i = i * 10) { //Count the number of digits.

    }
  }
}
