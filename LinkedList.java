public class LinkedList {
  // inner class
  private class Node {
    // fields -
    public Integer data;
    public Node next;
    public Node prev;

    // constructor
    public Node(int data) {
      this.data = data;
      this.next = null;
      this.prev = null;
    }

  }

  // private fields
  private Node head;
  private Node tail;
  private int size;

  // constructor is goign to be name of class + parameters
  public LinkedList() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  // insert a node at position...
  public void insert(int n, int index) {
    // if the index is 0 we are adding at the beginning.
    if (index == 0) {
      // If the size is 0 && index is 0 we have an empty list:
      if (size() == 0) {
        // new Node is the head and the tail
        head = new Node(n);
        tail = head;
      } else {
        // temp variable to hold our node and swap
        Node temp = new Node(n);
        temp.next = head;
        head = temp;
      }
    } else if (index == size()) {
      // if we insert at the end, the index is equal to the size (last elem)
      Node node = new Node(n);
      tail.next = node;
      node.prev = tail;
      tail = tail.next;
    }
    size++;
  }

  // public Node remove(int index) {
  // size--;
  // }

  public int size() {
    // return 0;
    return size;
  }

  // public String toString() {
  // String s = "[";

  // }

  public static void main(String[] args) {
    // System.out.print("Hello world!");
    // this.add(1)
  }
}