package algorithm.test.baekjoon.level05.exam10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String two = "ABC", three = "DEF", four = "GHI", five = "JKL", six = "MNO", seven = "PQRS",
        eight = "TUV", nine = "WXYZ";
    String[] alphabets = {two, three, four, five, six, seven, eight, nine};
    int result = 0;

    String str = br.readLine();
    for (int i = 0; i < str.length(); i++) {
      for (int k = 0; k < alphabets.length; k++) {
        if (include(alphabets[k], str.charAt(i))) {
          int time = k + 3;
          result += time;
        }
      }
    }

    System.out.println(result);

    br.close();
    // bw.flush();
    // bw.close();
  }

  static boolean include(String str, char c) {
    boolean result = false;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == c) {
        result = true;
      }
    }
    return result;
  }
}
