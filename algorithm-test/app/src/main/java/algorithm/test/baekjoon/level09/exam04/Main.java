package algorithm.test.baekjoon.level09.exam04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int count = 0;
    int n = Integer.valueOf(br.readLine());

    String[] s = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (isPrimeNum(s[i])) {
        count++;
      }
    }

    System.out.println(count);

    br.close();
    // bw.flush();
    // bw.close();
  }

  static boolean isPrimeNum(String str) {
    int i = Integer.valueOf(str);

    if (i == 1) {
      return false;
    }

    for (int j = 2; j < i; j++) {
      if (i % j == 0) {
        return false;
      }
    }

    return true;
  }
}
