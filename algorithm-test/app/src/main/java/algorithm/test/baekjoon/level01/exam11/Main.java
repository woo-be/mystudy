package algorithm.test.baekjoon.level01.exam11;

public class Main {
  public static void main(String[] args) {
    java.util.Scanner keyIn = new java.util.Scanner(System.in);

    // String a = keyIn.next();
    // String b = keyIn.next();
    // String c = keyIn.next();
    // long intA = Integer.parseInt(a.replaceAll("[^0-9]", ""));
    // long intB = Integer.parseInt(b.replaceAll("[^0-9]", ""));
    // long intC = Integer.parseInt(c.replaceAll("[^0-9]", ""));
    // System.out.println(intA + intB + intC);
    long a = keyIn.nextLong();
    long b = keyIn.nextLong();
    long c = keyIn.nextLong();
    System.out.println(a + b + c);
    keyIn.close();
  }
}

