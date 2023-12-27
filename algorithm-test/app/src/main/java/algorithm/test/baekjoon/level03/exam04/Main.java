package algorithm.test.baekjoon.level03.exam04;

public class Main {
  public static void main(String[] args) {

    java.util.Scanner input = new java.util.Scanner(System.in);

    int total = input.nextInt();
    int num = input.nextInt();
    int price, count;
    int sum = 0;

    for (int i = 0; i < num; i++) {
      price = input.nextInt();
      count = input.nextInt();
      sum = sum + (price * count);
    }

    if (total == sum) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }

    input.close();
  }
}
