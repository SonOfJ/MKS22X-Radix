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
    MyLinkedList<Integer> temp = new MyLinkedList<>(); //List of temporary values.
    int index = 0; //This will go through the place values.
    while (index < max) {
      if (index == 0) { //Ones place.
        for (int i = 0; i < data.length; i = i + 1) {
          if (data[i] % 10 >= 0) { //Positive number.
            buckets[10 + data[i] % 10].add(data[i]); //Put it in between 10 and 19.
          } else { //Negative number.
            buckets[9] + data[i] % 10].add(data[i]); //Put it in between 0 and 9.
          }
        }
      } else {
        while (temp.size() > 0) { //There is something in the linked list.
          int value = temp.removeFront()
          if ((int)(value / Math.pow(10, index)) % 10 >= 0) { //If the digit is positive...
            buckets[10 + (int)(value / Math.pow(10, index)) % 10].add(value); //Put it between 10 and 19.
          } else { //If the digit is negative...
            buckets[9 + (int)(value / Math.pow(10, index)) % 10].add(value); //Put it between 0 and 9.
          }
        }
      }
      for (int i = 0; i < 20; i = i + 1) {
        temp.extend[buckets[i]]; //Add on the buckets.
      }
      index = index + 1; //Make sure the place index keeps moving.
    }
    for (int i = 0; i < data.length; i = i + 1) {
      data[i] = temp.removeFront(); //Put everything back into the original array.
    }
  }
}
