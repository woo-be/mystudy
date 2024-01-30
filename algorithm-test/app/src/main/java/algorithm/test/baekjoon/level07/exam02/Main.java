package algorithm.test.baekjoon.level07.exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[][] arr = new int[9][9];
    int max = 0;
    int line = 0;
    int row = 0;

    for (int i = 0; i < 9; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 9; j++) {
        arr[i][j] = Integer.valueOf(st.nextToken());
      }
    }

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (arr[i][j] >= max) {
          max = arr[i][j];
          line = i + 1;
          row = j + 1;
        }
      }
    }

    System.out.println(max);
    System.out.println(line + " " + row);

    br.close();
    // bw.flush();
    // bw.close();
  }
}
