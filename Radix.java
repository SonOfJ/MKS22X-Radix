@SuppressWarnings({"unchecked", "rawtypes"})
public class Radix {
  public static void radixsort(int[] data) {
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
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
    String digits = "" + max;
    int runs = digits.length() - 1; //Number of passes needed.
    for (int i = 0; i <= runs; i = i + 1) {
      if (i == 0) { //First value.
        for (int j = 0; j < data.length; j = j + 1) {
          buckets[data[j] % 10 + 9].add(data[j]);
        }
      } else {
        Node<Integer> value = temp.start();
        buckets[value.getData() / (int)Math.pow(10, i) % 10].add(value.getData());
        while (value.hasNext()) {
          value = value.next();
          buckets[value.getData() / (int)Math.pow(10, i) % 10].add(value.getData());
        }
      }
      temp.clear();
      for (int j = 0; j < 20; j = j + 1) {
        temp.extend(buckets[j]);
      }
    }
    Node<Integer> value = temp.start();
    data[0] = value.getData();
    int index = 1;
    while (value.hasNext()) {
      value = value.next();
      data[index] = value.getData();
      index = index + 1;
    }
  }
}
