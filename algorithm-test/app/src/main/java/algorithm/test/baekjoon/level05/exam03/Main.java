package algorithm.test.baekjoon.level05.exam03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.valueOf(br.readLine());
    String[] strs = new String[t];

    for (int i = 0; i < t; i++) {
      String str = br.readLine();
      strs[i] = String.valueOf(str.charAt(0)) + String.valueOf(str.charAt(str.length() - 1));
    }

    for (String str : strs) {
      System.out.println(str);
    }

    br.close();
    // bw.flush();
    // bw.close();
  }
}
