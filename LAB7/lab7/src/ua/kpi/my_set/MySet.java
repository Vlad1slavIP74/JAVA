package ua.kpi.my_set;

import ua.kpi.singly_linked_list.SinglyLinkedList;
import ua.kpi.knight.Knight;

import java.util.Iterator;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class MySet implements Set, Collection {
  private SinglyLinkedList<Object> value;

  public MySet() {
    this.value = new SinglyLinkedList<>();
  }

  public MySet(Knight knight) {
    this.value = new SinglyLinkedList<>();
    add(knight);
  }

  public MySet(List<Knight> knights) {
    this.value = new SinglyLinkedList<>();
    addAll(knights);
  }

  public MySet(Object[] objects) {
    this.value = new SinglyLinkedList<>();
    for (Object object : objects) {
      value.addFirst(object);
    }
  }

  @Override
  public int size() {
    return value.getSize();
  }

  @Override
  public boolean isEmpty() {
    return value.isEmpty();
  }

  @Override
  public boolean contains(Object o) {
    return value.contains(o);
  }

  @Override
  public Iterator iterator() {
    return value.iterator();
  }

  @Override
  public Object[] toArray() {
    Object[] result = new Object[value.getSize()];
    int i = 0;
    for (Object o : value) {
      result[i++] = o;
    }
    return result;
  }

  @Override
  public Object[] toArray(Object[] a) {
    int i = 0;
    if (a.length >= size()) {
      for (Object o : value) {
        a[i++] = o;
      }
    } else {
      a = new Object[size()];
      for (Object o : value) {
        a[i++] = o;
      }
    }
    return a;
  }

  @Override
  public boolean add(Object o) {
    if (value.contains(o)) {
      return false;
    } else {
      value.addLast(o);
      return true;
    }
  }

  @Override
  public boolean remove(Object o) {
    return value.remove(o);
  }

  @Override
  public boolean containsAll(Collection c) {
    for (Object o : c) {
      if (!value.contains(o)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean addAll(Collection c) {
    int sizeBefore, sizeAfter;
    sizeBefore = size();

    for (Object elem : c) {
      this.add(elem);
    }

    sizeAfter = size();
    return sizeAfter - sizeBefore != 0;
  }

  @Override
  public boolean retainAll(Collection c) {
    int sizeBefore, sizeAfter;
    sizeBefore = size();
    MySet tempSet = new MySet();

    for (Object o : c) {
      if (contains(o)) {
        tempSet.add(o);
      }
    }

    clear();
    addAll(tempSet);
    sizeAfter = tempSet.size();
    return sizeAfter - sizeBefore != 0;
  }

  @Override
  public boolean removeAll(Collection c) {
    int sizeBefore, sizeAfter;
    sizeBefore = size();

    for (Object o : c) {
      remove(o);
    }

    sizeAfter = size();
    return sizeAfter - sizeBefore != 0;
  }

  @Override
  public void clear() {
    this.value = new SinglyLinkedList<>();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    MySet other = (MySet) o;
    for (Object elem : other) {
      if (!contains(elem)) {
        return false;
      }
    }

    return size() == other.size();

  }

  @Override
  public String toString() {
    String result = "{";
    Iterator it = iterator();

    result += it.next();
    while (it.hasNext()) {
      result += ", " + it.next();
    }

    result += "}";
    return result;
  }
}