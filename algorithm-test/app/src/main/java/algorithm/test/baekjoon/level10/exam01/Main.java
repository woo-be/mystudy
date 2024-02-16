package algorithm.test.baekjoon.level10.exam01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int hight = Integer.valueOf(br.readLine());
    int width = Integer.valueOf(br.readLine());

    System.out.print(hight * width);

    br.close();
    // bw.flush();
    // bw.close();
  }
}
