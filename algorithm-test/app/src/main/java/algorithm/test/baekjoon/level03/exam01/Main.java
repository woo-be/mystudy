package algorithm.test.baekjoon.level03.exam01;

public class Main {
  public static void main(String[] args) {

    java.util.Scanner input = new java.util.Scanner(System.in);

    int a = input.nextInt();

    for (int i = 0; i < 9; i++) {
      System.out.printf("%d * " + (i + 1) + " = %d\n", a, a * (i + 1));
    }



    input.close();
  }
}
