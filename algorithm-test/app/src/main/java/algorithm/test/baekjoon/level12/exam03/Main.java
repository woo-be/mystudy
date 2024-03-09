package algorithm.test.baekjoon.level12.exam03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr = new int[6];
    for (int i = 0; i < 6; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for (int x = -999; x <= 999; x++) {
      for (int y = -999; y <= 999; y++) {
        if (first(x, y, arr) && second(x, y, arr)) {
          System.out.println(x + " " + y);
          break;
        }
      }
    }

    br.close();
    // bw.flush();
    // bw.close();
  }

  static boolean first(int x, int y, int[] arr) {
    if (arr[0] * x + arr[1] * y == arr[2]) {
      return true;
    }
    return false;
  }

  static boolean second(int x, int y, int[] arr) {
    if (arr[3] * x + arr[4] * y == arr[5]) {
      return true;
    }
    return false;
  }
}
