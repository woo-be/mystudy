package algorithm.test.baekjoon.level09.exam03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    while (true) {

      int[] divisor = new int[100000];
      int index = 0;
      int sum = 0;
      int n = Integer.valueOf(br.readLine());
      if (n == -1) {
        break;
      }

      for (int i = 1; i < n; i++) {
        if (n % i == 0) {
          sum += i;
          divisor[index] = i;
          index++;
        }
      }

      if (sum == n) {
        bw.write(n + " = ");
        for (int k = 0; k < (index - 1); k++) {
          bw.write(divisor[k] + " + ");
        }
        bw.write(divisor[(index - 1)] + "\n");
      } else {
        bw.write(n + " is NOT perfect.\n");
      }

    }

    br.close();
    bw.flush();
    bw.close();
  }
}
