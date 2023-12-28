package bitcamp.util;

public class Test {

  public static void main(String[] args) {
    LinkedList list = new LinkedList();

    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    list.add("ddd");

    list.remove("ddd");

    list.add(3, "xxx");

    Object[] arr = list.toArray();
    for (Object value : arr) {
      System.out.println(value);
    }

    System.out.println();

  }
}
