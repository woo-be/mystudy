package algorithm.test.baekjoon.level05.exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str = br.readLine();
    int count = 0;

    try {
      int i = 0;
      while (true) {
        str.charAt(i);
        count++;
        i++;
      }
    } catch (IndexOutOfBoundsException e) {
      System.out.println(count);
    }

    br.close();
    // bw.flush();
    // bw.close();
  }
}
