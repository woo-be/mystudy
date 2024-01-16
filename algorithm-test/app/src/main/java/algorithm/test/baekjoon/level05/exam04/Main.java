package algorithm.test.baekjoon.level05.exam04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str = br.readLine();
    char c = str.charAt(0);

    System.out.println((int) c);

    br.close();
    // bw.flush();
    // bw.close();
  }
}
