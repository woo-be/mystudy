package algorithm.test.baekjoon.level06.exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str);
    int[] black = {1, 1, 2, 2, 2, 8};
    int[] diff = new int[6];

    for (int i = 0; i < 6; i++) {
      diff[i] = black[i] - Integer.valueOf(st.nextToken());
    }

    for (int i : diff) {
      System.out.print(i + " ");
    }

//    bw.flush();
//    bw.close();
  }
}
