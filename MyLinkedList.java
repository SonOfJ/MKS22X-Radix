class MyLinkedList{
  private int size;
  private Node start,end;
  public MyLinkedList() {
    size = 0; //Creates an empty list with length of zero
  }
  public int size() {
    return size; //Returns the length of the list
  }
  public boolean add(int value) {
    if (size == 0) { //If the list is only supposed to have one element
      Node element = new Node(value, null, null); //There can be no previous or next elements
      size = size + 1; //The size goes from zero to one
      start = element; //The first node would be the element
      end = element; //The last node would also be the element
      return true; //This is a boolean function
    } else { //What if the list were to have more than one element
      Node element = new Node(value, null, end); //The is no next element but the previous element would be the old last element
      size = size + 1; //Increase the size
      end.setNext(element); //Change the constructor of the old last element
      end = element; //New last element
      return true; //This is a boolean function
    }
  }
  public String toString() {
    String sad = "["; //Creates the string of a new list
    if (size == 0) {
      return "[]"; //This is what should be returned if the list is empty
    }
    Node index = start; //This runs through the entire list
    while (index != end) { //While index is not the last index
      sad = sad + index.getData() + ", "; //Add the current element to the string
      index = index.next(); //Changes to next element
    }
    sad = sad + index.getData() + "]"; //At the last element now
    return sad; //Return the final product
  }
  private Node getNthNode(int n) { //Helper function
    Node index = start;
    for(int i = 0; i < n; i = i + 1) { //Goes through the list until hitting n
      index = index.next();
    }
    return index; //Returns the desired node
  }
  public int get(int index) {
    if (index > size - 1 || index < 0) { //Invalid input for index
      throw new IndexOutOfBoundsException("Index is out of bounds.");
    }
    return getNthNode(index).getData(); //Uses helper function to get the correct node and then gets the correct value for that node
  }
  public int set(int index, int value) {
    if (index > size - 1 || index < 0) { //Invalid input for index
      throw new IndexOutOfBoundsException("Index is out of bounds.");
    }
    Node old = getNthNode(index); //Gets the node at the desired index
    int wanted = old.getData(); //Gets the old value of the wanted node to be returned later
    old.setData(value); //Puts in the new value
    return wanted; //Returns the final integer value
  }
  public boolean contains(int value) {
    Node index = start; //Will change with the progression of the function
    for(int i = 0; i < size; i = i + 1) {
      if (index.getData() == value) { //If the value has been found
        return true; //Return true
      }
      index = index.next(); //Change to the next node
    }
    return false; //Value is not found
  }
  public int indexOf(int value) {
    Node index = start; //Will change with the progression of the function
    for(int i = 0; i < size; i = i + 1) {
      if (index.getData() == value) { //If the value is found
        return i; //Return the index
      }
      index = index.next(); //Update the node to the next one
    }
    return -1; //If the value is never found
  }
  public void add(int index, int value) {
    if (size == 0 && index != 0 || size != 0 && index > size || index < 0) { //Invalid input for index
      throw new IndexOutOfBoundsException("Index is out of bounds.");
    }
    Node joke = getNthNode(index);
    if (size == 0) { //If adding to an empty list
      Node element = new Node(value, null, null); //There can be no previous or next elements
      size = size + 1; //The size goes from zero to one
      start = element; //The first node would be the element
      end = element; //The last node would also be the element
    } else if (index == size) { //If adding to the end of a list
      Node element = new Node(value, null, end); //The is no next element but the previous element would be the old last element
      size = size + 1; //Increase the size
      end.setNext(element); //Change the constructor of the old last element
      end = element; //New last element
    } else if (index == 0) { //If adding to the beginning of a list
      Node element = new Node(value, start, null); //The is no previous element
      size = size + 1; //Increase the size
      start.setPrev(element); //Change the constructor of the old first element
      start = element; //New first element
    } else { //If the element is in the middle of the list
      Node element = new Node(value, joke, joke.prev()); //The old node at the index is the next node and the previous old node is still the previous node
      size = size + 1; //Start and end are unaffected
      joke.prev().setNext(element); //Change the next of the node before
      joke.setPrev(element); //Change the previous of the node after
    }
  }
  public int remove(int index) {
    if (size == 0 || index > size - 1 || index < 0) { //Invalid input for index
      throw new IndexOutOfBoundsException("Index is out of bounds.");
    }
    Node old = getNthNode(index);
    if (index == size - 1) { //If removing at the end of a list
      old.prev().setNext(null); //Change the previous element's next to null
      size = size - 1; //Decrease the size
      end = old.prev(); //New last element
    } else if (index == 0) { //If removing at the beginning of a list
      old.next().setPrev(null); //Change the next element's previous to null
      size = size - 1; //Decrease the size
      start = old.next(); //New first element
    } else { //If the element is in the middle of the list
      old.next().setPrev(old.prev()); //Set the next node's previous to the previous node
      old.prev().setNext(old.next()); //Set the previous node's next to the next node
      size = size - 1; //Start and end are unaffected
    }
    return old.getData();
  }
  public boolean remove(Integer value) {
    if (contains(value)) { //Checks to see if value exists
      remove(indexOf(value)); //Remove at the index of value
      return true; //Return true
    }
    return false; //Return false
  }
  public void extend(MyLinkedList other) {
    if (size == 0 && other.size != 0) { //What if the first list were empty
      size = other.size;
      start = other.start;
      end = other.end;
      other.size = 0;
      other.start = null;
      other.end = null;
    }
    if (other.size != 0) { //What if the second list was not empty
      end.setNext(other.start); //The next element after the last of the first list is the first of the otehr list
      other.start.setPrev(end); //The element before the first of the other list is the last of the first list
      size = size + other.size; //Add the two sizes
      end = other.end; //The new end is the end of the other list
      other.size = 0; //The other list should be empty now
      other.start = null; //The other list should be empty now
      other.end = null; //The other list should be empty now
    }
  }
  public void clear() {
    size = 0;
    start = null;
    end = null;
  }
  public E removeFront() {
    if (size() == 0) {
      throw new NoSuchElementException("The list is empty.");
    }
    if (size == 1) {
      E hold = start.getData();
      clear();
      return hold;
    }
    start = start.next();
    start.setPrev(null);
    size = size - 1;
    return start.getData();
  }
}
