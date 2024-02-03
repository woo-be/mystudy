package algorithm.test.baekjoon.level08.exam01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    String n = st.nextToken();
    int b = Integer.valueOf(st.nextToken());

    char[] nArr = n.toCharArray();
    int[] arr = charArrToIntArr(nArr);

    for (int i : arr) {
      System.out.println(i);
    }

    int sum = 0;

    for (int i = 0; i < arr.length; i++) {
      sum += Math.pow(b, arr.length - (i + 1)) * arr[i];
    }

    System.out.println(sum);

    br.close();
    // bw.flush();
    // bw.close();
  }

  static int[] charArrToIntArr(char[] charArr) {
    int[] intArr = new int[charArr.length];
    for (int i = 0; i < charArr.length; i++) {
      if (charArr[i] >= '0' && charArr[i] <= '9') {
        intArr[i] = charArr[i] - '0';
      }
      if (charArr[i] >= 'A' && charArr[i] <= 'Z') {
        intArr[i] = charArr[i] - 'A' + 10;
      }
    }

    return intArr;
  }

}
