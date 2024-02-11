package algorithm.test;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    for (int i = 1; i <= n; i++) {
      String iToStr = String.valueOf(i);
      if (i % 3 == 0) {
        System.out.print("0 ");
      } else if (iToStr.length() == 1
          && (iToStr.charAt(0) == '3' || iToStr.charAt(0) == '6' || iToStr.charAt(0) == '9')) {
        System.out.print("0 ");
      } else if (iToStr.length() == 2
          && (iToStr.charAt(0) == '3' || iToStr.charAt(0) == '6' || iToStr.charAt(0) == '9'
              || iToStr.charAt(1) == '3' || iToStr.charAt(1) == '6' || iToStr.charAt(1) == '9')) {
        System.out.print("0 ");
      } else {
        System.out.print(i + " ");
      }
    }
  }
}
