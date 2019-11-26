package ua.kpi.singly_linked_list;

import java.util.Iterator;

public class SinglyLinkedList<E> implements Iterable<E> {
  private Node head;
  private Node tail;
  private int size;

  public SinglyLinkedList() {
    size = 0;
  }

  /**
   * This class keeps track of each element information.
   */
  private class Node {
    E element;
    Node next;

    public Node(E element, Node next) {
      this.element = element;
      this.next = next;
    }

    public boolean equals(Node other) {
      return this.element.equals(other.element);
    }
  }

  /**
   * Returns the size of the linked list.
   */
  public int getSize() {
    return size;
  }

  /**
   * Returns whether the list is empty or not.
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Adds element at the start.
   * @param element       element to add
   */
  public void addFirst(E element) {
    Node tmp = new Node(element, head);

    if (head == null) {
      head = tmp;
      tail = tmp;
    } {
      head = tmp;
    }

    size++;
  }

  /**
   * Adds element at the end.
   * @param element       element to add
   */
  public void addLast(E element) {
    Node tmp = new Node(element, null);

    if (tail == null) {
      head = tmp;
      tail = tmp;
    } else {
      tail.next = tmp;
      tail = tmp;
    }

    size++;
  }

  /**
   * Removes an element from the list.
   * @param e     the element to remove
   */
  public boolean remove(E e) {
    if (head.element.equals(e)) {
      head = head.next;
      size--;
      return true;
    }

    Node temp = this.head;

    while (temp != null) {
      if (temp.next.element.equals(e)) {
        temp.next = temp.next.next;
        size--;
        return true;
      }
      temp = temp.next;
    }

    return false;
  }

  /**
   * Returns whether the list contains the element.
   * @param element      a sought-for element
   */
  public boolean contains(E element) {
    Node temp = this.head;
    while (temp != null) {
      if (temp.element.equals(element)) {
        return true;
      }
      temp = temp.next;
    }
    return false;
  }


  @Override
  public Iterator<E> iterator() {
    return new Iterator<E>() {
      private Node temp = new Node(null, head);

      @Override
      public boolean hasNext() {
        return temp.next != null;
      }

      @Override
      public E next() {
        temp = temp.next;
        return temp.element;
      }
    };
  }

  @Override
  public String toString() {
    String result = "";
    Node temp = this.head;
    if (temp != null) {
      result += temp.element;
      temp = temp.next;
    }
    while (temp != null) {
      result += " -> " + temp.element;
      temp = temp.next;
    }
    return result;
  }
}