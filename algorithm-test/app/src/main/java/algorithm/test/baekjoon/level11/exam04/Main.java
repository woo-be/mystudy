package algorithm.test.baekjoon.level11.exam04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    long n = Integer.parseInt(br.readLine());
    System.out.println((n - 1) * (n - 2) / 2);
    System.out.println(2);

    br.close();
    // bw.flush();
    // bw.close();
    // i : 1    , 2    , 3    , 4    , ... , n-3    , n-2    , n-1
    // n : 2 ~ n, 3 ~ n, 4 ~ n, 5 ~ n, ... , n-2 ~ n, n-1 ~ n, n ~ n
    //   : n-1  , n-2  , n-3  , n-4  , ... , 3      , 2      , 1
    // k * (k + 1) / 2 -> 1부터 k까지의 합 공식
    // (n - 1) * (n) / 2 = (n^2 -n) / 2
  }
}
