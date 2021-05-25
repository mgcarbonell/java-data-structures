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

  // adds to the beginning
  public void addAtBeginning(int n) {
    if (size() == 0) {
      head = new Node(n);
      tail = head;
    } else {
      Node.temp = new Node(n);
      temp.next = head;
      head = temp;
    }

  }

  // adds at the end of the list
  public void addAtEnd(int n) {
    Node node = new Node(size());
    tail.next = node;
    node.prev = tail;
    tail = tail.next;
  }

  // insert a node with the value of n at position of index...
  public void add(int n, int index) {
    // if the index is 0 we are adding at the beginning.
    if (index == 0) {
      // If the size is 0 && index is 0 we have an empty list:
      addAtBeginning(0);
    } else if (index == size()) {
      // size() will return the last elem of list
      // we're adding at the end
      addAtEnd(size());
    } else {
      Node curr = head;
      int i = 0;
      while (i++ < index) {
        curr = curr.next;
      }
      // make the new node
      Node node = new Node(n);
      //
      node.next = curr;
      node.prev = curr.prev;
      curr.prev.next = node;
      curr.prev = node;
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