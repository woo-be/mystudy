package algorithm.test.baekjoon.level04.exam07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int arr[] = new int[30];

    for (int i = 0; i < 28; i++) {
      arr[Integer.valueOf(br.readLine()) - 1]++;
    }

    for (int j = 0; j < 30; j++) {
      if (arr[j] == 0) {
        bw.write(String.valueOf(j + 1));
        bw.newLine();
      }
    }

    bw.flush();
    bw.close();
    br.close();

  }
}
