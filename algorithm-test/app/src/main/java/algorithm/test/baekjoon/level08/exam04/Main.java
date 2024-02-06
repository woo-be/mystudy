package algorithm.test.baekjoon.level08.exam04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int dotCount = 2;
    int n = Integer.valueOf(br.readLine());

    for (int i = 0; i < n; i++) {
      dotCount = (dotCount * 2) - 1;
    }

    System.out.print(dotCount * dotCount);

    br.close();
    // bw.flush();
    // bw.close();
  }
}
