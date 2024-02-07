package algorithm.test.baekjoon.level08.exam05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.valueOf(br.readLine());
    int x = 1;
    int i = 0;
    while (true) {
      int start = x;
      x = x + (i * 6);
      int end = x;
      if (n >= start && n <= end) {
        System.out.println(i + 1);
        break;
      }
      i++;
    }

    br.close();
    // bw.flush();
    // bw.close();
  }
}
