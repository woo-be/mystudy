package algorithm.test.baekjoon.level13.exam01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[1001];
    int count = 0;

    for (int i = 0; i < n; i++) {
      int input = Integer.parseInt(br.readLine());
      int minIndex = 0, maxIndex = count;
      System.out.println("1: minIndex = " + minIndex + ", maxIndex = " + maxIndex);
      int compIndex = maxIndex / 2;
      while (true) {
        if (input < arr[compIndex]) {
          maxIndex = compIndex;
        } else {
          minIndex = compIndex;
        }
        compIndex = (minIndex + maxIndex) / 2;
        System.out.println("2: minIndex = " + minIndex + ", maxIndex = " + maxIndex);
        System.out.println("compIndex = " + compIndex);
        if (compIndex == minIndex || compIndex == maxIndex) {
          System.out.println("input = " + input);
          System.out.println("******값대입******");
          int countTemp = count;
          while (true) {
            if (countTemp == compIndex) {
              break;
            }
            arr[countTemp] = arr[countTemp - 1];
            countTemp--;
            System.out.println("배열밀기!");
          }
          arr[compIndex] = input;
          count++;
          break;
        }
      }
      System.out.println("배열상태:");
      for (int k = 0; k < n + 1; k++) {
        System.out.println("arr[" + k + "] = " + arr[k]);
      }
      System.out.println("count = " + count);
      System.out.println("---------------" + (i + 1) + "번째 for문 실행됨!---------------------");
    }

    System.out.println("--------결과----------");

    for (int i = 0; i < n + 1; i++) {
      System.out.println(arr[i]);
    }

    br.close();
    // bw.flush();
    // bw.close();
  }
}
// input: 21 15 2 7 -2 11 0 19 3 4 10
// index : 0 1 2 3 4 5 6 7 8 9 10
// output: -2 0 2 3 4 7 10 11 15 19 21
//
// min = 0, max = 10
// input: 9
// temp: 10 / 2 = 5,
// comp 9, output[5]
// min = 5
// temp: (min + max) / 2 = 7
// comp 9, output[7]
// max = 7
// temp: (min + max) / 2 = 6
// comp 9, output[6]
// max = 6
// temp: (min + max) / 2 = 5
// comp 9, output[5]
// min = 5 --> index == min || index == max => break;
//
//
//
//

