package algorithm.test.baekjoon.level04.exam10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.valueOf(br.readLine()); // 1
    String[] strs = br.readLine().split(" "); // 50
    int count = strs.length; // 1
    int[] scores = new int[count];
    double[] fakeScores = new double[count];
    double sum = 0;
    double average = 0;

    for (int i = 0; i < strs.length; i++) {
      scores[i] = Integer.valueOf(strs[i]);
    }

    int max = scores[0];

    for (int i = 1; i < scores.length; i++) {
      // if (count == 1) {
      // break;
      // }
      if (max < scores[i]) {
        max = scores[i];
      }
    }

    for (int i = 0; i < scores.length; i++) {
      fakeScores[i] = (double) scores[i] / max * 100;
    }

    for (int i = 0; i < fakeScores.length; i++) {
      sum += fakeScores[i];
    }

    average = sum / count;

    bw.write(String.valueOf(average));

    bw.flush();
    bw.close();
    br.close();

  }
}
