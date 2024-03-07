package algorithm.test.baekjoon.level12.exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int result = 0;
    for (int i = 1; i <= n; i++) {
      if (cal(i) == n) {
        result = i;
        break;
      }
    }

    System.out.println(result);


    br.close();
    // bw.flush();
    // bw.close();
  }

  static int cal(int i) {
    int sum = i;

    while (i > 0) {
      sum += i % 10;
      i /= 10;
    }

    return sum;
  }
}

// 1234 => 1 + 2 + 3 + 4
// 1234 % 10 = 4, 1234 / 10 = 123
// 123 % 10 = 3, 123 / 10 = 12
// 12 % 10 = 2, 12 / 10 = 1
// 1 % 10 = 1, 1 / 10 = 0


