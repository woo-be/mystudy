package algorithm.test.baekjoon.level06.exam04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str = br.readLine();
    int length = str.length();
    int result = 1;

      for (int i = 0; i < (length / 2); i++) {
        if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
          result = 0;
        }
      }

    System.out.println(result);

    br.close();
    //    bw.flush();
    //    bw.close();
  }
}
