package algorithm.test.baekjoon.level06.exam08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    double creditSum = 0;
    double multipleSum = 0;

    for (int i = 0; i < 20; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      st.nextToken(); // 과목명
      double credit = Double.valueOf(st.nextToken()); // 학점
      String rating = st.nextToken(); // 등급
      if (rating.equals("P")) {
        continue;
      }
      double grade = ratingToGrade(rating); // 과목평점
      double multiple = credit * grade;

      multipleSum += multiple; // 학점*과목평점의 합
      creditSum += credit; // 학점 총합
    }

    System.out.println(multipleSum / creditSum);

    br.close();
  }

  static double ratingToGrade(String rating) {
    switch (rating) {
      case "A+":
        return 4.5;
      case "A0":
        return 4.0;
      case "B+":
        return 3.5;
      case "B0":
        return 3.0;
      case "C+":
        return 2.5;
      case "C0":
        return 2.0;
      case "D+":
        return 1.5;
      case "D0":
        return 1.0;
      case "F":
        return 0.0;
      default:
        return 0.0;
    }
  }
}
