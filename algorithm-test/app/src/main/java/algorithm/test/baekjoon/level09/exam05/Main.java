package algorithm.test.baekjoon.level09.exam05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.valueOf(br.readLine());
    int m = Integer.valueOf(br.readLine());
    int sum = 0;
    int min = 0;

    for (int i = n; i <= m; i++) {
      if (isPrimeNum(i)) {
        if (min == 0) {
          min = i;
        }
        sum += i;
      }
    }

    if (sum == 0) {
      System.out.println(-1);
    } else {
      System.out.println(sum);
      System.out.println(min);
    }

    // bw.flush();
    // bw.close();
  }

  static boolean isPrimeNum(int i) {
    if (i == 1) {
      return false;
    }

    for (int k = 2; k < (i - 1); k++) {
      if (i % k == 0) {
        return false;
      }
    }

    return true;
  }
}
