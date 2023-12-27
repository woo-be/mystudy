package bitcamp.util;

public class Test {

  public static void main(String[] args) {
    LinkedList list = new LinkedList();

    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    list.add("ddd");

    Object[] arr = list.toArray();

    for (Object value : arr) {
      System.out.printf("%s, ", value);
    }

    System.out.println();

//    System.out.println(list.get(0));
//    System.out.println(list.get(1));
//    System.out.println(list.get(2));
//    System.out.println(list.get(3));
  }
}
