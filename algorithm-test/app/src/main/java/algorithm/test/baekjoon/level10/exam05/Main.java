package algorithm.test.baekjoon.level10.exam05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    long minX;
    long maxX;
    long minY;
    long maxY;
    StringTokenizer st = new StringTokenizer(br.readLine());
    minX = maxX = Integer.parseInt(st.nextToken());
    minY = maxY = Integer.parseInt(st.nextToken());
    for (int i = 0; i < (n - 1); i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      if (x < minX) {
        minX = x;
      } else if (x > maxX) {
        maxX = x;
      }

      if (y < minY) {
        minY = y;
      } else if (y > maxY) {
        maxY = y;
      }
    }

    System.out.println((maxX - minX) * (maxY - minY));


    br.close();
    // bw.flush();
    // bw.close();
  }
}
