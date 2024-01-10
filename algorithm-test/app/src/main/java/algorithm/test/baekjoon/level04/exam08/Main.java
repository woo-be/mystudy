package algorithm.test.baekjoon.level04.exam08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] arr = new int[10];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.valueOf(br.readLine()) % 42;
    }

    arr = Arrays.stream(arr).distinct().toArray();

    bw.write(String.valueOf(arr.length));

    bw.flush();
    bw.close();
    br.close();

  }
}
