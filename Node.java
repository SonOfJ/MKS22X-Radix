public class Node<E> {
  private E data;
  private Node<E> next;
  private Node<E> prev;
  public Node (E newData, Node<E> newNext, Node<E> newPrev) {
    data = newData;
    next = newNext;
    prev = newPrev;
  }
  public E getData() {
    return data;
  }
  public Node<E> next() {
    return next;
  }
  public Node<E> prev() {
    return prev;
  }
  public E setData(E i) {
    E K = data;
    data = i;
    return K;
  }
  public void setNext(Node<E> other) {
    next = other;
  }
  public void setPrev(Node<E> other) {
    prev = other;
  }
  public String toString() {
    String K = "" + data;
    return K;
  }
  public boolean hasNext() {
    if (next == null) {
      return false;
    }
    return true;
  }
}
