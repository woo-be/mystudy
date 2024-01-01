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

    int sum;
    while (true) {
      String str = br.readLine();
      if (str == null)
        break;
      String[] strs = str.split(" ");
      int a = Integer.valueOf(strs[0]);
      int b = Integer.valueOf(strs[1]);
      sum = a + b;
      bw.write(String.valueOf(sum));
      bw.newLine();
    }
    bw.flush();
    bw.close();
  }
}
