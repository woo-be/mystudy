package algorithm.test.baekjoon.level05.exam05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.valueOf(br.readLine()); // 숫자의 개수
    int[] nums = new int[n]; // 입력될 숫자들을 담을 배열
    int sum = 0;
    String str = br.readLine();

    for (int i = 0; i < n; i++) { // 입력된 문자열을 배열에 담는다.
      nums[i] = Integer.valueOf(str.charAt(i)) - 48; // ascii
    }

    for (int num : nums) {
      sum += num;
    }

    System.out.println(sum);

    br.close();
    // bw.flush();
    // bw.close();
  }
}
