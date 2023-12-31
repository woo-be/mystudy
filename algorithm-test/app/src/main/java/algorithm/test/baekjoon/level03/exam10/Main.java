package algorithm.test.baekjoon.level03.exam10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.valueOf(br.readLine());

    for (int i = 1; i <= n; i++) {

      for (int k = i; (n - k) > 0; k++) {
        bw.write(" ");
      }

      for (int j = 0; j < i; j++) {
        bw.write("*");
      }
      bw.newLine();
    }
    bw.flush();
    bw.close();
  }
}
