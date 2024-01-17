package algorithm.test.baekjoon.level05.exam06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str = br.readLine();
    int[] nums = new int[26];

    for (int j = 0; j < nums.length; j++) {
      nums[j] = -1;
    }

    int i = 0;
    int location = 0;
    try {
      while (true) {
        char c = str.charAt(i);
        if (nums[c - 'a'] != -1) {
          i++;
          location++;
          continue;
        }
        nums[c - 'a'] = location;
        i++;
        location++;
      }
    } catch (IndexOutOfBoundsException e) {
      for (int num : nums) {
        System.out.print(num + " ");
      }
    }

    br.close();
    // bw.flush();
    // bw.close();
  }
}
