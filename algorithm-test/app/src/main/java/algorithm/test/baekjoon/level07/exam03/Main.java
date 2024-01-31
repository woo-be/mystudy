package algorithm.test.baekjoon.level07.exam03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[][] a = new String[5][15];

    for (int i = 0; i < 5; i++) {
      a[i] = strToArr15(br.readLine());
    }

    for (int i = 0; i < 15; i++) {
      for (int j = 0; j < 5; j++) {
        System.out.print(a[j][i]);
      }
    }

    br.close();
    // bw.flush();
    // bw.close();
  }

  static String[] strToArr15(String a) {

    String[] strs = new String[15];
    for (int j = 0; j < strs.length; j++) {
      strs[j] = "";
    }

    String[] input = a.split("");
    for (int k = 0; k < input.length; k++) {
      strs[k] = input[k];
    }

    return strs;
  }

}
