package algorithm.test.baekjoon.level12.exam06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int cnt = -1;
    int weightSum = 0;

    loop: for (int i = 0; i <= 1667; i++) {
      for (int j = 0; j <= 1000; j++) {
        if (i * 3 + j * 5 == n) {
          cnt = i + j;
          break loop;
        }
      }
    }

    System.out.println(cnt);

    br.close();
    // bw.flush();
    // bw.close();
  }
}
