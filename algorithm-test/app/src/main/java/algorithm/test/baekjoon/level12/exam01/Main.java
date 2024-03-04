package algorithm.test.baekjoon.level12.exam01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    IntArr arr = new IntArr();

    for (int i = 0; i < n; i++) {
      arr.add(Integer.parseInt(st.nextToken()));
    }

    System.out.println(arr.find(n, m));

    br.close();
    // bw.flush();
    // bw.close();
  }

}


class IntArr {
  int[] arr = new int[100];
  int index = 0;

  void add(int i) {
    arr[index] = i;
    index++;
  }

  int find(int n, int m) {
    int result = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        for (int k = j + 1; k < n; k++) {
          if (sum(i, j, k) > m) {
            continue;
          } else {
            if (m - sum(i, j, k) < m - result) {
              result = sum(i, j, k);
            }
          }
        }
      }
    }
    return result;
  }

  int sum(int i, int j, int k) {
    return arr[i] + arr[j] + arr[k];
  }
}
