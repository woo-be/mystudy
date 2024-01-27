package algorithm.test.baekjoon.level06.exam07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.valueOf(br.readLine());
    int count = 0;

    for (int i = 0; i < n; i++) {
      String str = br.readLine();
      if (isGroupWord(str)) {
        count++;
      }
    }

    System.out.println(count);

    br.close();
    // bw.flush();
    // bw.close();
  }

  static boolean isGroupWord(String str) {
    boolean result = true;
    String temp = dupliStr(str);

    for (int i = 0; i < temp.length(); i++) {
      for (int j = i + 1; j < temp.length(); j++) {
        if (temp.charAt(i) == temp.charAt(j)) {
          result = false;
        }
      }
    }

    return result;
  }

  static String dupliStr(String str) { // ccazzzzbb -> cazb

    StringBuilder sb = new StringBuilder(str);
    int cursor = 0;

    for (int i = 0; i < str.length() - 1; i++) {
      if (str.charAt(i) == str.charAt(i + 1)) {
        sb.deleteCharAt(cursor);
      } else {
        cursor++;
      }
    }

    return sb.toString();
  }

}
