package algorithm.test.baekjoon.level02.exam03;

public class Main {
  public static void main(String[] args) {

    java.util.Scanner input = new java.util.Scanner(System.in);

    int year = input.nextInt();

    if (year % 4 == 0) {
      if (year % 100 != 0) {
        System.out.println("1");
      } else if (year % 400 == 0) {
        System.out.println("1");
      } else
        System.out.println("0");
    } else
      System.out.println("0");

    input.close();
  }
}
