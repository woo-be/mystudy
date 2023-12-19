package algorithm.test.baekjoon.level02.exam01;

public class Main {
  public static void main(String[] args) {

    java.util.Scanner input = new java.util.Scanner(System.in);

    int a = input.nextInt();
    int b = input.nextInt();

    if (a > b) {
      System.out.println(">");
    }

    if (a < b) {
      System.out.println("<");
    }

    if (a == b) {
      System.out.println("==");
    }

    input.close();
  }
}
