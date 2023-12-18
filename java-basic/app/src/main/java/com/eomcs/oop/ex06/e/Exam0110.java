// final 사용법: 상속 불가!
package com.eomcs.oop.ex06.e;

// 클래스에 final 을 붙이면 이 클래스의 서브 클래스를 만들 수 없다.
// - 서브 클래스의 생성을 방지하여
// 기존 클래스를 대체하지 못하도록 할 때 사용한다.
// - 예)
// java.lang.String
//
final class A1 {
}

// 서브 클래스를 정의하지 못한다.
// class A2 extends A1{
//
// }


// final 클래스를 상속 받을 수 없다.
public class Exam0110 // extends A
{
  public static void main(String[] args) {
    m(new A1());

    // 객체 대신 서브 클래스의 객체를 전달 할 ㅜ수 없다.
    // m(new A2());
  }

  static void m(A1 obj) {

  }

}
