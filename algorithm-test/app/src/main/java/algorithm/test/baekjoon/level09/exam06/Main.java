package algorithm.test.baekjoon.level09.exam06;

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

    while (true) {
      if (n == 1) {
        break;
      }
      for (int i = 2; i <= n; i++) {
        if (n % i == 0) {
          System.out.println(i);
          n = n / i;
          break;
        }
      }
    }

    br.close();
    // bw.flush();
    // bw.close();
  }
}
