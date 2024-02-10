package algorithm.test.baekjoon.level09.exam01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    while (true) {
      String[] line = br.readLine().split(" ");
      int a = Integer.valueOf(line[0]);
      int b = Integer.valueOf(line[1]);

      if (a == 0 & b == 0)
        break;

      if (b % a == 0) {
        bw.write("factor");
      } else if (a % b == 0) {
        bw.write("multiple");
      } else {
        bw.write("neither");
      }
      bw.newLine();
    }

    br.close();
    bw.flush();
    bw.close();
  }
}
