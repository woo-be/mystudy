package algorithm.test.baekjoon.level04.exam01;

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

    int v = Integer.valueOf(br.readLine());

    int result = 0;

    for (int i = 0; i < n; i++) {
      if (Integer.valueOf(strs[i]) == v) {
        result++;
      }
    }
    bw.write(String.valueOf(result));
    br.close();
    bw.flush();
    bw.close();
  }
}
