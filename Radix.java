public class Radix {
  public static void radixsort(int[] data) {
    @SuppressWarnings("unchecked")
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    for (int i = 0; i < 20; i = i + 1) {
      buckets[i] = new MyLinkedList<>();
    }
    int max = data[0]; //Variable that points to the highest value in a list.
    for (int i = 0; i < data.length; i = i + 1) { //Find the max value.
      if (Math.abs(data[i]) > max) {
        max = Math.abs(data[i]);
      }
    }
    max = (int)Math.log10(max) + 1; //Get the total number of digits for the maximum value.
    int index = 0; //This will go through the place values.
    
    while (index < max) {

    }

    }
  }
}
