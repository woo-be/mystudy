package algorithm.test.baekjoon.level03.exam02;

public class Main {
  public static void main(String[] args) {

    java.util.Scanner input = new java.util.Scanner(System.in);

    int t = input.nextInt();
    int a, b;
    int[] results = new int[t];

    for (int i = 0; i < t; i++) {
      a = input.nextInt();
      b = input.nextInt();
      results[i] = a + b;
    }

    for (int result : results)
      System.out.println(result);

    input.close();
  }
}
