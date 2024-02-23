package algorithm.test.baekjoon.level10.exam08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    int[] arr = {a, b, c};
    Arrays.sort(arr);

    if (arr[0] + arr[1] > arr[2]) {
      System.out.println(arr[0] + arr[1] + arr[2]);
    } else {
      System.out.println((arr[0] + arr[1]) * 2 - 1);
    }

    br.close();
    bw.flush();
    bw.close();
  }
}
