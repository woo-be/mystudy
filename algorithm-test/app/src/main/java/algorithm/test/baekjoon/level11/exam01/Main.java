package algorithm.test.baekjoon.level11.exam01;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {

    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 시간 복잡도 = 입력 값에 따른 연산 횟수?
    // 시간 복잡도는 입력 값에 따라 변화하거나 변화하지 않을 수 도 있다.
    // 입력 값에 따라 연산 횟수가 변하지 않는다 -> 입력 값에 따라 시간복잡도가 변하지 않는다.
    // ex1) int i = (n + 1) * 2;
    // 해당 코드는 n + 1, 앞의 결과 * 2, 앞의 결과를 i에 대입, 총 3번의 연산이 수행된다.
    // 따라서 해당 코드의 시간 복잡도는 3이다.
    // ex2)for (int i = 0; i < n; i++) {}
    // i = 0 1번, i++ n번, 총 n + 1번의 연산이 수행된다
    // 해당 코드의 시간 복잡도 n + 1.
    // 시간 복잡도의 표기법 - 빅 오 표기법
    // 시간 복잡도의 계수를 제외한 최고차항만을 사용하여 표기한다.
    // ex2의 최고 차항은 n 이므로 O(n)으로 표기한다.
    // 최고 차항이 상수항인 경우 O(1)으로 표기한다.
    // O(1)은 입력 값에 따라 시간 복잡도가 변하지 않는다.
    // O(n)은 입력 값에 따라 시간 복잡도가 일정하게 증가한다. 선형 복잡도, 선형 시간이라 함.
    // O(log n) 로그 시간이라 한다.
    // O(n^2) 2차 시간.
    // O(2^n) 지수 시간.
    // O(n!)

    System.out.println(1);
    System.out.println(0);

    // br.close();
    // bw.flush();
    // bw.close();
  }
}
