@SuppressWarnings({"unchecked", "rawtypes"})
public class Radix {
  public static void radixsort(int[] data) {
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20]; //Initialize the buckets.
    for (int i = 0; i < 20; i = i + 1) {
      buckets[i] = new MyLinkedList<Integer>();
    }
    MyLinkedList<Integer> temp = new MyLinkedList<Integer>(); //List of temporary values.
    int max = data[0]; //Variable that points to the highest value in a list.
    for (int i = 0; i < data.length; i = i + 1) { //Find the max value.
      if (data[i] > max) {
        max = data[i];
      }
    }
    String digits = "" + max; //Being creative about finding the total number of digits.
    int runs = digits.length() - 1; //Number of passes needed.
    for (int i = 0; i <= runs; i = i + 1) {
      if (i == 0) { //First run.
        for (int j = 0; j < data.length; j = j + 1) {
          buckets[data[j] % 10 + 9].add(data[j]); //Place from 9 to 18.
        }
      } else { //The rest of the runs.
        Node<Integer> value = temp.start();
        buckets[value.getData() / (int)Math.pow(10, i) % 10].add(value.getData()); //Find the appropriate place value.
        while (value.hasNext()) {
          value = value.next();
          buckets[value.getData() / (int)Math.pow(10, i) % 10].add(value.getData()); //Find the appropriate place value.
        }
      }
      temp.clear(); //Clean it all.
      for (int j = 0; j < 20; j = j + 1) {
        temp.extend(buckets[j]); //Add the buckets.
      }
    }
    Node<Integer> value = temp.start();
    data[0] = value.getData(); //Put the start at the start.
    int index = 1;
    while (value.hasNext()) { //Time to put everything else back in to the original array.
      value = value.next();
      data[index] = value.getData();
      index = index + 1;
    }
  }
}
