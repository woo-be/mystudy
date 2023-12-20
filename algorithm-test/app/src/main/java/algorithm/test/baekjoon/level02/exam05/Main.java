package algorithm.test.baekjoon.level02.exam05;

public class Main {
  public static void main(String[] args) {

    java.util.Scanner input = new java.util.Scanner(System.in);

    int h1 = input.nextInt();
    int m1 = input.nextInt();

    int m2 = m1 - 45;

    if (m2 < 0) {
      m2 += 60;
      h1 -= 1;
      if (h1 < 0) {
        h1 += 24;
      }
    }

    System.out.println(h1 + " " + m2);

    input.close();
  }
}
