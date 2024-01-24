package algorithm.test.baekjoon.level06.exam03;

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

    for(int i = 1; i <= n; i++) {
      StringBuilder sb = new StringBuilder();
      for(int j = n; j > i; j--) {
        sb.append(" ");
      }
      for(int k = 0; k < (2 * i - 1); k++) {
        sb.append("*");
      }
      bw.write(sb.toString());
      bw.newLine();
    }

    for(int i = n-1; i >=1; i--) {
      StringBuilder sb = new StringBuilder();
      for(int j = n; j > i; j--) {
        sb.append(" ");
      }
      for(int k = 0; k < (2 * i) - 1; k++) {
        sb.append("*");
      }
      bw.write(sb.toString());
      bw.newLine();
    }

    bw.flush();
    bw.close();
  }
}
