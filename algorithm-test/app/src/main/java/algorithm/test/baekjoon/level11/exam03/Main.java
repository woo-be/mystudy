package algorithm.test.baekjoon.level11.exam03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    long n = Integer.parseInt(br.readLine());
    System.out.println(n * n);
    System.out.println(2);

    br.close();
    // bw.flush();
    // bw.close();
  }
}
