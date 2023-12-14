package algorithm.test.baekjoon.level01.exam10;

public class Main {
  public static void main(String[] args) {
    java.util.Scanner keyIn = new java.util.Scanner(System.in);
    int a = keyIn.nextInt();
    int b = keyIn.nextInt();
    int b1, b2, b3;
    b1 = b / 100;
    b2 = b % 100 / 10;
    b3 = b % 10;
    System.out.println(a * b3);
    System.out.println(a * b2);
    System.out.println(a * b1);
    System.out.println(a * b);
  }
}

