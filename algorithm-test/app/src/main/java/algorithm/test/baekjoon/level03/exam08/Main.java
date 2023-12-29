package algorithm.test.baekjoon.level03.exam08;

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
      String[] strs = br.readLine().split(" ");
      int one = Integer.valueOf(strs[0]);
      int two = Integer.valueOf(strs[1]);
      int sum = one + two;
      bw.write("Case #" + (i + 1) + ": ");
      bw.write(one + " + " + two + " = " + sum);
      bw.newLine();
    }

    bw.flush();
    bw.close();

  }
}
