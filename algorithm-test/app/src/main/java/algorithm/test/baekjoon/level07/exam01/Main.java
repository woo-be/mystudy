package algorithm.test.baekjoon.level07.exam01;

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

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.valueOf(st.nextToken());
    int m = Integer.valueOf(st.nextToken());
    int[][] a = new int[n][m];
    int[][] b = new int[n][m];

    for (int i = 0; i < n; i++) {
      StringTokenizer stA = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        a[i][j] = Integer.valueOf(stA.nextToken());
      }
    }

    for (int i = 0; i < n; i++) {
      StringTokenizer stB = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        b[i][j] = Integer.valueOf(stB.nextToken());
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        bw.write(String.valueOf(a[i][j] + b[i][j]) + " ");
      }
      bw.newLine();
    }

    br.close();
    bw.flush();
    bw.close();
  }

}
