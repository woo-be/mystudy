package algorithm.test.baekjoon.level08.exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.valueOf(st.nextToken());
    int b = Integer.valueOf(st.nextToken());
    int max;

    for (int i = 0; true; i++) {
      if ((n / (Math.pow(b, i)) < b)) {
        max = i;
        break;
      }
    }

    for (int i = max; i >= 0; i--) {
      int value = (int) (Math.pow(b, i));
      if ((n / value) >= 10) {
        System.out.print(numToChar(n / value));
      } else {
        System.out.print(n / value);
      }
      n = n % value;
    }

    br.close();
    // bw.flush();
    // bw.close();
  }

  static char numToChar(double i) {
    return (char) (i + 55);
  }
}
