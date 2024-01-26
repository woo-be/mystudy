package algorithm.test.baekjoon.level06.exam05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int alphabets[] = new int[26];
    int max = 0;
    int maxIndex = 0;
    String str = br.readLine();
    char result = ' ';

    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) >= 'a') {
        alphabets[str.charAt(i) - 'a']++;
      } else {
        alphabets[str.charAt(i) - 'A']++;
      }
    }

    for (int i = 0; i < alphabets.length; i++) {
      if (max < alphabets[i]) {
        max = alphabets[i];
        maxIndex = i;
        result = (char) (maxIndex + 'A');
      } else if (max == alphabets[i]) {
        max = alphabets[i];
        result = '?';
      }
    }

    System.out.println(result);

    br.close();
    //    bw.flush();
    //    bw.close();
  }
}
