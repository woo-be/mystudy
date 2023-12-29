package algorithm.test.baekjoon.level03.exam06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.valueOf(br.readLine());

    for (int i = 0; i < t; i++) {
      String str = br.readLine();
      String[] a = str.split(" ");

      int one = Integer.parseInt(a[0]);
      int two = Integer.parseInt(a[1]);
      int result = one + two;

      bw.write(String.valueOf(result) + "\n");

    }

    bw.flush();

  }
}
