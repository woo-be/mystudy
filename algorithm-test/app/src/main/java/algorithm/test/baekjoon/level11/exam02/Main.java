package algorithm.test.baekjoon.level11.exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    System.out.println(Integer.parseInt(br.readLine()));
    System.out.println(1);
    // 코드 1의 수행 횟수는 n, 최고차항의 차수는 1이다.
    

    br.close();
    // bw.flush();
    // bw.close();
  }
}

// sum <- 0; - 변수 sum을 0으로 초기화한다.
// for i <- 1 to n - i가 1부터 n일떄 까지 반복한다.
// sum <- sum + A[i] - 변수 sum에 sum + A[i]의 값을 저장한다.
