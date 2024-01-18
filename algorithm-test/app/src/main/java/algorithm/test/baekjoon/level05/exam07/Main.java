package algorithm.test.baekjoon.level05.exam07;

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

    for (int i = 0; i < n; i++) {
      String str = br.readLine();
      String[] strs = str.split(" ");
      int repeat = Integer.valueOf(strs[0]);
      String target = strs[1];

      for (int j = 0; j < target.length(); j++) {
        for (int k = 0; k < repeat; k++) {
          bw.write(target.charAt(j));
        }
      }
      bw.newLine();
    }

    br.close();
    bw.flush();
    bw.close();
  }
}
