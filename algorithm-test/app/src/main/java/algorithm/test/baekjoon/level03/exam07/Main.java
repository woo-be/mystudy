package algorithm.test.baekjoon.level03.exam07;

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
      String testCase = br.readLine();
      String[] testCases = testCase.split(" ");
      int one = Integer.valueOf(testCases[0]);
      int two = Integer.valueOf(testCases[1]);
      int sum = one + two;
      bw.write("Case #" + (i + 1) + ": " + sum);
      bw.newLine();
    }

    bw.flush();

  }
}
