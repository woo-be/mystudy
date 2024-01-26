package algorithm.test.baekjoon.level06.exam06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str = br.readLine();
    String[] strs = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=", "1"};
    for (int i = 0; i < strs.length; i++) {
        str = str.replaceAll("[0-9]", "x");
      }
     System.out.println(str);

    br.close();
    //    bw.flush();
    //    bw.close();
  }
}
