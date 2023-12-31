package algorithm.test.baekjoon.level03.exam12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str = br.readLine();
    String[] strs = str.split(" ");
    int n = Integer.valueOf(strs[0]);
    int x = Integer.valueOf(strs[1]);
    String str1 = br.readLine();
    String[] strs1 = str1.split(" ");

    for (int i = 0; i < n; i++) {
      if (Integer.valueOf(strs1[i]) < x) {
        bw.write(strs1[i] + " ");
      }
    }
    bw.flush();
    bw.close();
    br.close();
  }
}
