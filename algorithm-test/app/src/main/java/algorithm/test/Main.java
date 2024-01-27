package algorithm.test;

public class Main {
  public static void main(String[] args) throws Exception {
    boolean result = true;
    String temp = "abcb";

    for (int i = 0; i < temp.length(); i++) {
      for (int j = i + 1; j < temp.length(); j++) {
        if (temp.charAt(i) == temp.charAt(j)) {
          result = false;
        }
      }
    }

    System.out.println(result);
  }
}

