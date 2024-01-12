package algorithm.test.baekjoon.level04.exam10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.valueOf(br.readLine());
    String[] strs = br.readLine().split(" ");
    int count = strs.length;
    int[] scores = new int[count];
    double[] fakeScores = new double[count];
    int max = scores[0];
    double sum = 0;
    double average = 0;

    for (int i = 0; i < strs.length; i++) { // 점수 배열 초기화
      scores[i] = Integer.valueOf(strs[i]);
    }

    for (int i = 1; i < scores.length; i++) { // 최댓값 찾기
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

    // bw.flush();
    // bw.close();
    // br.close();

  }
}
