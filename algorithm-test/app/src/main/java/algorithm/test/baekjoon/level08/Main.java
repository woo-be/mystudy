package algorithm.test.baekjoon.level08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[][] white = new int[100][100];
    int count = Integer.valueOf(br.readLine());
    int area = 0;

    for (int i = 0; i < count; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.valueOf(st.nextToken());
      int y = Integer.valueOf(st.nextToken());
      for (int j = 0; j < 10; j++) {
        for (int k = 0; k < 10; k++) {
          white[x + j][y + k] = 1;
        }
      }
    }

    for (int i = 0; i < white.length; i++) {
      for (int j = 0; j < white[i].length; j++) {
        if (white[i][j] == 1) {
          area++;
        }
      }
    }

    System.out.println(area);

    br.close();
    // bw.flush();
    // bw.close();
  }
}
