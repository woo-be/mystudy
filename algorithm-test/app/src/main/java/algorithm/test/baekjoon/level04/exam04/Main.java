package algorithm.test.baekjoon.level04.exam04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] nums = new int[9];
    int max = 0;
    int count = 0;

    for (int i = 0; i < 9; i++) {
      nums[i] = Integer.valueOf(br.readLine());
      if (nums[i] > max) {
        max = nums[i];
        count = i + 1;
      }
    }
    bw.write(String.valueOf(max));
    bw.newLine();
    bw.write(String.valueOf(count));
    bw.flush();
    bw.close();

  }
}
