package algorithm.test.baekjoon.level11.exam06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    long n = Integer.parseInt(br.readLine());
    long complex = 0;
    for (int i = 1; i <= n - 2; i++) {
      for (int j = (i + 1); j <= (n - 1); j++) {
        for (int k = (j + 1); k <= n; k++) {
          complex++;
        }
      }
    }

    System.out.println(complex);
    System.out.println(3);

    br.close();
    // bw.flush();
    // bw.close();
  }
}

// i : 1 , 2 , 3 , 4 , ..., n-4 , n-3 , n-2
// j : 2 ~ n-1, 3 ~ n-1, 4 ~ n-1, 5 ~ m-1, ..., n-3 ~ n-1, n-2 ~ n-1, n-1
// k :

// i : 1
// j : 2 , 3 , 4 , 5 , ..., n-3 , n-2 , n-1
// k : 3 ~ n, 4 ~ n, 5 ~ n, 6 ~ n, ..., n-2 ~ n, n-1 ~ n, n
// n-2 , n-3 , n-4 , n-5 , ..., 3 , 2 , 1 >>> 1부터n-2까지의합

// 1~n-2 + 1~n-3 + 1~n-4 + 1~n-5 + ... + 1~3 + 1~2 + 1~1

