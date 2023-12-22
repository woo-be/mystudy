package algorithm.test.baekjoon.level02.exam07;

public class Main {
  public static void main(String[] args) {

    java.util.Scanner input = new java.util.Scanner(System.in);

    int a = input.nextInt();
    int b = input.nextInt();
    int c = input.nextInt();

    if (a == b && b == c) {
      System.out.println(10000 + a * 1000);
    } else if (a == b) {
      System.out.println(1000 + a * 100);
    } else if (a == c) {
      System.out.println(1000 + a * 100);
    } else if (b == c) {
      System.out.println(1000 + b * 100);
    } else {
      if (a > b && a > c) {
        System.out.println(a * 100);
      }
      if (b > a && b > c) {
        System.out.println(b * 100);
      }
      if (c > a && c > b) {
        System.out.println(c * 100);
      }
    }



    input.close();
  }
}
