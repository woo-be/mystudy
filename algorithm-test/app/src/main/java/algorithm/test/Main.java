package algorithm.test;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    String s = "가나다라";
    int i = 123;
    int a = 25;

    String str = String.format("%d\t%%-" + a + "s%s", i, s);
    System.out.println(str);

  }

}
