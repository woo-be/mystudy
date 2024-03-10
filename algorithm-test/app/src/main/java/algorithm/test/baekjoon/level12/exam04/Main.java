package algorithm.test.baekjoon.level12.exam04;

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
    char[][] board = new char[n][m];
    int min = 64;
    int temp = 0;

    for (int i = 0; i < n; i++) {
      String str = br.readLine();
      for (int j = 0; j < m; j++) {
        board[i][j] = str.charAt(j);
      }
    }

    for (int i = 0; i < n - 7; i++) {
      for (int j = 0; j < m - 7; j++) {
        temp = cal(board, i, j);
        if (temp < min) {
          min = temp;
        }
      }
    }

    System.out.println(min);

    br.close();
    // bw.flush();
    // bw.close();
  }

  // board[i][j] 기준 가장 적게 칠하는 사각형의 개수를 리턴하는 메서드
  static int cal(char[][] board, int i, int j) {

    // 첫번째 사각형이 흰색일 때
    int temp1 = 0;
    char comp = 'W';
    for (int x = i; x < i + 8; x++) {
      for (int y = j; y < j + 8; y++) {
        if (board[x][y] != comp) {
          temp1++;
        }
        if (comp == 'W') {
          comp = 'B';
        } else {
          comp = 'W';
        }
      }
      if (comp == 'W') {
        comp = 'B';
      } else {
        comp = 'W';
      }
    }

    // 첫번째 사각형이 검정색일 때
    int temp2 = 0;
    comp = 'B';
    for (int x = i; x < i + 8; x++) {
      for (int y = j; y < j + 8; y++) {
        if (board[x][y] != comp) {
          temp2++;
        }
        if (comp == 'W') {
          comp = 'B';
        } else {
          comp = 'W';
        }
      }
      if (comp == 'W') {
        comp = 'B';
      } else {
        comp = 'W';
      }
    }

    return temp1 < temp2 ? temp1 : temp2;
  }
}
