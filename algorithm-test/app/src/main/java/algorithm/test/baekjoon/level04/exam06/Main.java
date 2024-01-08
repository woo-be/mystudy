package algorithm.test.baekjoon.level04.exam06;

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

    for (int i = 0; i < n; i++) {
      baskets[i] = i + 1;
    }

    for (int j = 0; j < m; j++) {
      String str2 = br.readLine();
      String[] strs2 = str2.split(" ");
      int first = Integer.valueOf(strs2[0]) - 1;
      int second = Integer.valueOf(strs2[1]) - 1;
      int temp = 0;
      temp = baskets[first];
      baskets[first] = baskets[second];
      baskets[second] = temp;
    }

    for (int k = 0; k < n; k++) {
      bw.write(String.valueOf(baskets[k]) + " ");
    }

    bw.flush();
    bw.close();
    br.close();

  }
}
