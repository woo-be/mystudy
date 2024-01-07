package algorithm.test.baekjoon.level04.exam03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str1 = br.readLine();
    String[] strs1 = str1.split(" ");
    int n = Integer.valueOf(strs1[0]);
    int m = Integer.valueOf(strs1[1]);
    int[] baskets = new int[n];

    for (int a = 0; a < m; a++) {
      String str2 = br.readLine();
      String[] strs2 = str2.split(" ");
      int i = Integer.valueOf(strs2[0]);
      int j = Integer.valueOf(strs2[1]);
      int k = Integer.valueOf(strs2[2]);

      for (; i <= j; i++) {
        baskets[(i - 1)] = k;
      }
    }

    for (int x = 0; x < n; x++) {
      bw.write(String.valueOf(baskets[x]));
      bw.write(" ");
    }

    bw.flush();
    bw.close();
    br.close();

  }
}
