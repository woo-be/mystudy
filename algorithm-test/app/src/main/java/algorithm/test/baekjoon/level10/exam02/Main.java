package algorithm.test.baekjoon.level10.exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int x = Integer.valueOf(st.nextToken());
    int y = Integer.valueOf(st.nextToken());
    int w = Integer.valueOf(st.nextToken());
    int h = Integer.valueOf(st.nextToken());

    int width1 = x;
    int width2 = w - x;
    int hight1 = y;
    int hight2 = h - y;
    int[] values = {width1, width2, hight1, hight2};
    int min = 1000;

    for (int i : values) {
      if (i < min) {
        min = i;
      }
    }

    System.out.println(min);

    br.close();
    // bw.flush();
    // bw.close();
  }
}
