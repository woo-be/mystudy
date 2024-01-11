package algorithm.test.baekjoon.level04.exam09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] strs1 = br.readLine().split(" ");
    int n = Integer.valueOf(strs1[0]);
    int m = Integer.valueOf(strs1[1]);
    int[] v = new int[n];

    for (int i = 0; i < n; i++) {
      v[i] = i + 1;
    }

    for (int j = 0; j < m; j++) {
      String[] strs2 = br.readLine().split(" ");
      int a = Integer.valueOf(strs2[0]);
      int b = Integer.valueOf(strs2[1]);
      int difference = b - a;

      if (difference % 2 == 0) {
        int std = (a + b) / 2;
        int repeat = b - std;
        for (int k = 1; k <= repeat; k++) {
          int temp = v[(std - 1) - k];
          v[(std - 1) - k] = v[(std - 1) + k];
          v[(std - 1) + k] = temp;
        }
      } else {
        int repeat = (difference + 1) / 2;
        for (int l = 0; l < repeat; l++) {
          int temp = v[(b - 1) - l];
          v[(b - 1) - l] = v[(a - 1) + l];
          v[(a - 1) + l] = temp;
        }
      }
    }

    String[] result = new String[n];
    for (int i = 0; i < n; i++) {
      result[i] = String.valueOf(v[i]);
    }

    for (int i = 0; i < n; i++) {
      bw.write(result[i] + " ");
    }

    bw.flush();
    bw.close();
    br.close();

  }
}
