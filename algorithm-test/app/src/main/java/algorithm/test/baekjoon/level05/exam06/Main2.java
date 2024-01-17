package algorithm.test.baekjoon.level05.exam06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main2 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    String s = br.readLine();
    int[] alphabets = new int[26];
    Arrays.fill(alphabets, -1);
    for (char c : s.toCharArray()) {
      if (alphabets[c - 'a'] == -1) {
        alphabets[c - 'a'] = s.indexOf(c);
      }
    }
    for (int i : alphabets) {
      sb.append(i).append(" ");
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}
