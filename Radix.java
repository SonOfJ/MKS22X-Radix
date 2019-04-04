public class Radix {
  public static void radixsort(int[] data) {
    @SuppressWarnings("unchecked")
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    for (int i = 0; i < 20; i = i + 1) {
      buckets[i] = new MyLinkedList<>();
    }
    MyLinkedList<Integer> temp = new MyLinkedList<>(); //List of temporary values.
    int max = data[0]; //Variable that points to the highest value in a list.
    for (int i = 0; i < data.length; i = i + 1) { //Find the max value.
      if (data[i] > max) {
        max = data[i];
      }
    }
    String digits = "" + max;
    int runs = digits.length() - 1; //Number of passes needed.
    for (int i = 0; i < runs; i = i + 1) {
      if (i == 0) { //First value.
        for (int j = 0; j < data.length; j = j + 1) {
          buckets[data[i] % 10 + 9].add(data[i]);
        }
      } else {
        buckets[temp.start().getData() / Math.pow(10, i) % 10].add(temp.start().getData());
        while (temp.start().hasNext()) {
          temp.start() = temp.start().next();
          buckets[temp.start().getData() / Math.pow(10, i) % 10].add(temp.start().getData());
        }
      }
      temp.clear();
      for (int j = 0; j < 20; j = j + 1) {
        temp.extend(buckets[j]);
      }
    }
    data[0] = temp.start().getData();
    int index = 1;
    while (temp.start().hasNext()) {
      temp.start() = temp.start().next();
      data[i] = temp.start().getData();
      i = i + 1;
    }
  }
}
