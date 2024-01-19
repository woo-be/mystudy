package algorithm.test.baekjoon.level05.exam08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str = br.readLine();
    String[] strs = str.split(" ");
    int length = strs.length;

    for (int i = 0; i < strs.length; i++) {
      if (strs[i].equals("")) {
        length -= 1;
      }
    }

    System.out.println(length);

    br.close();
    // bw.flush();
    // bw.close();
  }
}
