@SuppressWarnings({"unchecked", "rawtypes"})
public class Radix {
  public static void radixsort(int[] data) {
    if (data.length != 0) {
      MyLinkedList<Integer>[] buckets = new MyLinkedList[20]; //Initialize the buckets.
      for (int i = 0; i < 20; i = i + 1) {
        buckets[i] = new MyLinkedList<Integer>();
      }
      MyLinkedList<Integer> temp = new MyLinkedList<Integer>(); //List of temporary values.
      int max = Math.abs(data[0]); //Variable that points to the highest value in a list.
      for (int i = 0; i < data.length; i = i + 1) { //Find the max value.
        if (Math.abs(data[i]) > max) {
          max = Math.abs(data[i]);
        }
      }
      String digits = "" + max; //Being creative about finding the total number of digits.
      int runs = digits.length(); //Number of passes needed.
      for (int i = 1; i <= runs; i = i + 1) {
        for (int j = 0; j < data.length; j = j + 1) {
          int index = Math.abs((int)(data[j] / (Math.pow(10, i - 1)))) % 10; //Bucket index.
          if (data[j] >= 0) {
            buckets[index + 10].add(data[j]); //Place the digits of positive numbers from 10 to 19.
          } else {
            buckets[9 - index].add(data[j]); //Place the digits of negative numbers from 0 to 9.
          }
        }
        int count = 0;
        for (int j = 0; j < 20; j = j + 1) {
          int size = buckets[j].size();
          for (int k = 0; k < size; k = k + 1) {
            data[count] = buckets[j].removeFront(); //Add everything back to the original array.
            count = count + 1;
          }
        }
      }
    }
  }
}
