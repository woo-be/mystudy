package algorithm.test.baekjoon.level03.exam05;

public class Main {
  public static void main(String[] args) {

    java.util.Scanner input = new java.util.Scanner(System.in);

    int n = input.nextInt();

    int count = n / 4;

    while (count > 0) {
      System.out.print("long ");
      count--;
    }

    System.out.print("int");

    input.close();
  }
}
