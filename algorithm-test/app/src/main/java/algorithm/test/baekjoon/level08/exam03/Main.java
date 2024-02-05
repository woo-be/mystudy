package algorithm.test.baekjoon.level08.exam03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int quarter, dime, nickel, penny;
    int t = Integer.valueOf(br.readLine());

    for (int i = 0; i < t; i++) {
      int rest = Integer.valueOf(br.readLine());
      quarter = rest / 25;
      rest %= 25;
      dime = rest / 10;
      rest %= 10;
      nickel = rest / 5;
      rest %= 5;
      penny = rest / 1;
      bw.write(quarter + " " + dime + " " + nickel + " " + penny);
      bw.newLine();
    }


    br.close();
    bw.flush();
    bw.close();
  }
}
