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
  // as the author we can manipulate private, as a user cannot
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
      Node temp = new Node(n);
      temp.next = head;
      head = temp;
    }
    size++;
  }

  // adds at the end of the list
  public void addAtEnd(int n) {
    Node node = new Node(size());
    tail.next = node;
    node.prev = tail;
    tail = tail.next;
    size++;
  }

  // insert a node with the value of n at position of index...
  // we could potentially flip this around so that addAtBeg && addAtEnd
  // reference add instead of the other way.
  public void add(int n, int index) {
    // if the index is 0 we are adding at the beginning.
    if (index == 0) {
      // If the size is 0 && index is 0 we have an empty list:
      addAtBeginning(n);
    } else if (index == size()) {
      // size() will return the last elem of list
      // we're adding at the end
      addAtEnd(n);
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
      curr.prev.next = node; // prev && next are travs
      curr.prev = node;
      size++;
    }
  }

  public Node remove(int index) {
    int storedSize = size; // store the size
    size--;
    Node curr = head;
    if (index == 0) {
      // if we're removing the head set head's next to head
      head = head.next;
      return curr;
    } else if (index == storedSize) {
      // if we're removing from the end set the tail
      tail = tail.prev;
      tail.next.prev = null;
      tail.next = null;
      return tail;
    } else {
      int i = 0;
      while (i++ < index) {
        curr = curr.next;
      }
      Node node = curr;
      curr.prev.next = curr.next;
      curr.next.prev = curr.prev;
      return node;
    }
  }

  public int size() {
    // return 0;
    return size;
  }

  public String toString() {
    String s = "["; // s = string
    Node curr = head;
    while (curr.next != null) {
      s += curr.data + ", ";
      curr = curr.next;
    }

    return s + curr.data + "]";
  }

  public static void main(String[] args) {
    // System.out.print("Hello world!");
    // this.add(1)
    LinkedList list = new LinkedList();
    // list.add(1, 0);
    // list.add(2, 0);
    // list.add(3, 0);
    list.addAtBeginning(1);
    list.addAtBeginning(2);
    list.addAtBeginning(3);
    System.out.println(list.toString());

  }
}

// Draw it out && psuedo code it to write it out from memory
// Look @ solution to diagram it out