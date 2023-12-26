package algorithm.test.baekjoon.level03.exam03;

public class Main {
  public static void main(String[] args) {

    java.util.Scanner input = new java.util.Scanner(System.in);

    int n = input.nextInt();
    int result = 0;

    for (int i = 0; i < n; i++) {
      result = result + (i + 1);
    }

    System.out.println(result);

    input.close();
  }
}
