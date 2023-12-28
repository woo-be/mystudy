package bitcamp.util;

public class LinkedList {

  private Node first;
  private Node last;
  private int size;

  public void add(Object value) {
    Node node = new Node();
    node.value = value;

    if (first == null) {
      first = last = node;

    } else {
      last.next = node;
      last = node;
    }
    size++;
  }

    public Object[] toArray() {
      Object[] arr = new Object[size];
      Node node = first;
      int index = 0;
      while (index < size) {
        arr[index++] = node.value;
        node = node.next;
      }
    return arr;
  }

  public Object get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다.");
    }

    int cursor = 0;
    Node node = first;
    while (++cursor <= index) {
      node = node.next;
    }
    return node.value;
  }

  public Object set(int index, Object value) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다.");
    }

    Object old;
    int cursor = 0;
    Node node = first;
    while (++cursor <= index) {
      node = node.next;
    }
    old = node.value;
    node.value = value;
    return old;
  }

  public void add(int index, Object value) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다.");
    }

    Node node = new Node();
    node.value = value;

    if (first == null) {
      first = last = node;

    } else if (index == 0) {
      node.next = first;
      first = node;

    } else if (index == size) {
      last.next = node;
      last = node;

    } else {
      int cursor = 0;
      Node currNode = first;
      while (cursor++ < index) {
        currNode = currNode.next;
      }
      node.next = currNode.next;
      currNode.next = node;
    }
    size++;
  }

  public Object remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다.");
    }

    Node deleted;

    if (size == 1) {
      deleted = first;
      first = last = null;

    } else if (index == 0) {
      deleted = first;
      first = first.next;

    } else {
      int cursor = 0;
      Node node = first;
      while (++cursor < index) {
        node = node.next;
      }
      deleted = node.next;
      node.next = node.next.next;
      if (index == (size - 1)) {
        last = node;
      }
    }

    Object old = deleted.value;
    deleted.value = null;
    deleted.next = null;
    size--;
    return old;
  }

  public boolean remove(Object value) {

    Node prevNode = null;
    Node node = first;
    while (node != null) {
      if (node.value.equals(value)) {
        break;
      }
      prevNode = node;
      node = node.next;
    }

    if (node == null) {
      return false;
    }

    if (node == first) {
      first = first.next;
    } else {
      prevNode.next = node.next;
      if (node == last) {
        last = prevNode;
      }
    }
    size--;
    return true;
  }


}


// add, toArray, get, set, add, remove, remove, toArray(arr)
