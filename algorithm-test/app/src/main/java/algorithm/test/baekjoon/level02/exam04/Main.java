package algorithm.test.baekjoon.level02.exam04;

public class Main {
  public static void main(String[] args) {

    java.util.Scanner input = new java.util.Scanner(System.in);

    int x = input.nextInt();
    int y = input.nextInt();

    if (x > 0 && y > 0)
      System.out.println("1");

    if (x > 0 && y < 0)
      System.out.println("4");

    if (x < 0 && y > 0)
      System.out.println("2");

    if (x < 0 && y < 0)
      System.out.println("3");

    input.close();
  }
}
