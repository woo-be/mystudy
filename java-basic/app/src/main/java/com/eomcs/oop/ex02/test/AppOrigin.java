package com.eomcs.oop.ex02.test;

// # 관련된 기능(메서드)을 묶어 분류하기
// 1) 분류 전
// 2) 메서드를 클래스로 묶어 분류하기
// 3) 클래스 변수 도입
// 4) 클래스 변수의 한계 확인
// 5) 인스턴스 변수 도입
// 6) 인스턴스 메서드 활용
// 7) 클래스를 역할에 따라 패키지로 분류하기
// - Calculator 클래스를 향후 유지보수하기 쉽도록 별도의 패키지로 분류한다.
// - com.eomcs.opp.ex02.step07.util 패키지를 만들어 분류한다.
// - import 를 이용하여 클래스의 패키지 정보를 지정한다.
//
public class AppOrigin {

  public static void main(String[] args) {
    // - 연산자 우선 순위를 고려하지 않고 순서대로 계산하라!
    // 식1) 2 + 3 - 1 * 7 / 3 = ?
    // 식2) 3 * 2 + 7 / 4 - 5 = ?

    int result = 0;

    result = plus(2, 3);
    result = minus(result, 1);
    result = multiple(result, 7);
    result = divide(result, 3);

    System.out.printf("result = %d\n", result);
  }

  static int plus(int a, int b) {
    return a + b;
  }

  static int minus(int a, int b) {
    return a - b;
  }

  static int multiple(int a, int b) {
    return a * b;
  }

  static int divide(int a, int b) {
    return a / b;
  }
}


