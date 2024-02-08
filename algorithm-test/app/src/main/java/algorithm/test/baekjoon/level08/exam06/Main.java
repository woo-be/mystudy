package algorithm.test.baekjoon.level08.exam06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int x = Integer.valueOf(br.readLine());
    int start = 0;
    int end = 0;
    int line = 0;
    int index = 0;

    int i = 0;
    while (true) {
      end = start + i;
      if (x > start && x <= end) {
        line = i;
        index = x - start;
        break;
      }
      start = end;
      i++;
    }

    if (line % 2 == 1) {
      System.out.println(((line + 1) - index) + "/" + index);
    } else {
      System.out.println(index + "/" + ((line + 1) - index));
    }

    br.close();
    // bw.flush();
    // bw.close();
  }
}
