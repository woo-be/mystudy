package algorithm.test.baekjoon.level12.exam05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int result = 0;
    int cnt = 0;
    int i = 666;

    while (true) {
      int temp = 0;
      if (isContain666(i)) {
        temp = i;
        cnt++;
      }
      if (cnt == n) {
        result = temp;
        break;
      }
      i++;
    }

    System.out.println(result);

    br.close();
    // bw.flush();
    // bw.close();
  }

  static boolean isContain666(int i) {
    if (String.valueOf(i).contains("666")) {
      return true;
    }
    return false;
  }
}

