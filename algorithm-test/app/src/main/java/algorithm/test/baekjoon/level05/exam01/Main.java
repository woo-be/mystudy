package algorithm.test.baekjoon.level05.exam01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String s = br.readLine();
    int i = Integer.valueOf(br.readLine());

    System.out.println(s.charAt(i - 1));

    br.close();
    // bw.flush();
    // bw.close();
  }
}
