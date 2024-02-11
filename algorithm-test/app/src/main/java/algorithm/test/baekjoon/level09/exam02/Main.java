package algorithm.test.baekjoon.level09.exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.valueOf(st.nextToken());
    int k = Integer.valueOf(st.nextToken());
    int temp = 0;
    int count = 0;

    for (int i = 1; i <= n; i++) {
      if (n % i == 0) {
        temp = i;
        count++;
        if (count == k) {
          break;
        }
      }
    }
    if (count < k) {
      System.out.println(0);
    } else {
      System.out.println(temp);
    }

    br.close();
    // bw.flush();
    // bw.close();
  }
}
