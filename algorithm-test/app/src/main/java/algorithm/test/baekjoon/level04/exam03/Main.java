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

    int n = Integer.valueOf(br.readLine());
    String str = br.readLine();
    String[] strs = str.split(" ");
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = Integer.valueOf(strs[i]);
    }

    int min = nums[0], max = nums[0];

    for (int j = 1; j < n; j++) {
      if (nums[j] < min) {
        min = nums[j];
      }
      if (nums[j] > max) {
        max = nums[j];
      }
    }

    bw.write(String.valueOf(min) + " " + String.valueOf(max));
    bw.flush();
    bw.close();
  }
}

