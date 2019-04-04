import java.util.*;
public class MyLinkedList<E> {
  private int size;
  private Node start;
  private Node end;
  public MyLinkedList() {
  }
  public int size() {
    return size; //Returns the length of the list.
  }
  public String toString() {
    String sad = "["; //Creates the string of a new list.
    if (size == 0) {
      return "[]"; //This is what should be returned if the list is empty.
    }
    Node index = start; //This runs through the entire list.
    while (index != end) { //While index is not the last index.
      sad = sad + index.getData() + ", "; //Add the current element to the string.
      index = index.next(); //Changes to next element.
    }
    sad = sad + index.getData() + "]"; //At the last element now.
    return sad; //Return the final product.
  }
  public void clear() {
    size = 0;
    start = null;
    end = null;
  }
  public void add(E value) {
    if (size == 0) { //If the list is only supposed to have one element.
      Node element = new Node(value, null, null); //There can be no previous or next elements.
      size = size + 1; //The size goes from zero to one.
      start = element; //The first node would be the element.
      end = element; //The last node would also be the element.
    } else { //What if the list were to have more than one element.
      Node element = new Node(value, null, end); //The is no next element but the previous element would be the old last element.
      size = size + 1; //Increase the size.
      end.setNext(element); //Change the constructor of the old last element.
      end = element; //New last element.
    }
  }
  public void add(int index, Node<E> value) {
    if (size == 0 && index != 0 || size != 0 && index > size || index < 0) { //Invalid input for index.
      throw new IndexOutOfBoundsException("Index is out of bounds.");
    }
    Node joke = getNthNode(index);
    if (size == 0) { //If adding to an empty list.
      Node element = new Node(value, null, null); //There can be no previous or next elements.
      size = size + 1; //The size goes from zero to one.
      start = element; //The first node would be the element.
      end = element; //The last node would also be the element.
    } else if (index == size) { //If adding to the end of a list.
      Node element = new Node(value, null, end); //The is no next element but the previous element would be the old last element.
      size = size + 1; //Increase the size.
      end.setNext(element); //Change the constructor of the old last element.
      end = element; //New last element.
    } else if (index == 0) { //If adding to the beginning of a list.
      Node element = new Node(value, start, null); //The is no previous element.
      size = size + 1; //Increase the size.
      start.setPrev(element); //Change the constructor of the old first element.
      start = element; //New first element.
    } else { //If the element is in the middle of the list.
      Node element = new Node(value, joke, joke.prev()); //The old node at the index is the next node and the previous old node is still the previous node.
      size = size + 1; //Start and end are unaffected.
      joke.prev().setNext(element); //Change the next of the node before.
      joke.setPrev(element); //Change the previous of the node after.
    }
  }
  public void extend(MyLinkedList<E> other) {
    if (size == 0 && other.size != 0) { //What if the first list were empty?
      size = other.size;
      start = other.start;
      end = other.end;
      other.size = 0;
      other.start = null;
      other.end = null;
    }
    if (other.size != 0) { //What if the second list were not empty?
      end.setNext(other.start); //The next element after the last of the first list is the first of the other list.
      other.start.setPrev(end); //The element before the first of the other list is the last of the first list.
      size = size + other.size; //Add the two sizes.
      end = other.end; //The new end is the end of the other list.
      other.size = 0; //The other list should be empty now.
      other.start = null; //The other list should be empty now.
      other.end = null; //The other list should be empty now.
    }
  }
  private Node<E> getNthNode(int n) { //Helper function.
    Node index = start;
    for(int i = 0; i < n; i = i + 1) { //Goes through the list until hitting n.
      index = index.next();
    }
    return index; //Returns the desired node.
  }
  public Node<E> removeFront() {
    if (size() == 0) {
      throw new NoSuchElementException("The list is empty.");
    }
    if (size == 1) {
      Node<E> hold = start.getData();
      clear();
      return hold;
    }
    start = start.next();
    start.setPrev(null);
    size = size - 1;
    return start.getData();
  }
  public Node<E> start() {
    return start;
  }
}
