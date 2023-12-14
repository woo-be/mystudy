package algorithm.test.baekjoon.level01.exam09;

public class Main {
  public static void main(String[] args) {
    java.util.Scanner keyIn = new java.util.Scanner(System.in);
    int a = keyIn.nextInt();
    int b = keyIn.nextInt();
    int c = keyIn.nextInt();
    System.out.println((a + b) % c);
    System.out.println(((a % c) + (b % c)) % c);
    System.out.println((a * b) % c);
    System.out.println(((a % c) * (b % c)) % c);
    keyIn.close();
  }
}


