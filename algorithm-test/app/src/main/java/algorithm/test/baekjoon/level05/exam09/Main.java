package algorithm.test.baekjoon.level05.exam09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str = br.readLine();
    String[] strs = str.split(" ");
    String sangGuen1 = strs[0];
    String sangGuen2 = strs[1];
    int sangSu1, sangSu2;
    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();

    for (int i = 0; i < sangGuen1.length(); i++) {
      char a = sangGuen1.charAt((sangGuen1.length() - 1) - i);
      sb1.append(a);
    }
    sangSu1 = Integer.valueOf(sb1.toString());

    for (int i = 0; i < sangGuen2.length(); i++) {
      char a = sangGuen2.charAt((sangGuen2.length() - 1) - i);
      sb2.append(a);
    }
    sangSu2 = Integer.valueOf(sb2.toString());

    System.out.println(sangSu1 > sangSu2 ? sangSu1 : sangSu2);

    br.close();
    // bw.flush();
    // bw.close();
  }
}
