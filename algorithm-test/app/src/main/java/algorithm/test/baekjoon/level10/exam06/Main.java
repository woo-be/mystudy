package algorithm.test.baekjoon.level10.exam06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int firstA = Integer.parseInt(br.readLine());
    int secondA = Integer.parseInt(br.readLine());
    int thirdA = Integer.parseInt(br.readLine());

    if (firstA + secondA + thirdA != 180) {
      System.out.println("Error");
    } else if (firstA == 60 && secondA == 60 && thirdA == 60) {
      System.out.println("Equilateral");
    } else if (firstA == secondA || secondA == thirdA) {
      System.out.println("Isosceles");
    } else {
      System.out.println("Scalene");
    }

    br.close();
  }
}
