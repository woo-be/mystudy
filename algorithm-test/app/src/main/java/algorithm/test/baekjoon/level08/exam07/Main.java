package algorithm.test.baekjoon.level08.exam07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    double a = Integer.valueOf(st.nextToken());
    double b = Integer.valueOf(st.nextToken());
    double v = Integer.valueOf(st.nextToken());
    double day = 0;

    double temp = v - a;
    day = Math.ceil(temp / (a - b)) + 1;

    System.out.println((int) day);

    br.close();
    // bw.flush();
    // bw.close();
  }
}
