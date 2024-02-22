package algorithm.test.baekjoon.level10.exam07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    while (true) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      if (a == 0 && b == 0 && c == 0) {
        break;
      }

      if (!isTriangle(a, b, c)) {
        bw.write("Invalid");
        bw.newLine();
        continue;
      }

      if (isEquilateral(a, b, c)) {
        bw.write("Equilateral");
        bw.newLine();
        continue;

      } else if (isIsosceles(a, b, c)) {
        bw.write("Isosceles");
        bw.newLine();
        continue;

      } else {
        bw.write("Scalene");
        bw.newLine();
        continue;
      }

    }

    br.close();
    bw.flush();
    bw.close();
  }

  static boolean isTriangle(int a, int b, int c) {
    if (a >= b && a >= c) {
      if (a >= (b + c)) {
        return false;
      }
    } else if (b >= a && b >= c) {
      if (b >= (a + c)) {
        return false;
      }
    } else if (c >= a && c >= b) {
      if (c >= (a + b)) {
        return false;
      }
    }
    return true;
  }

  static boolean isEquilateral(int a, int b, int c) {
    if (a == b && b == c) {
      return true;
    } else {
      return false;
    }
  }

  static boolean isIsosceles(int a, int b, int c) {
    if (a == b && b != c) {
      return true;
    } else if (a == c && a != b) {
      return true;
    } else if (b == c && a != b) {
      return true;
    } else {
      return false;
    }
  }
}
