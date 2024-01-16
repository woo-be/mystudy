package com.eomcs.reflect.ex06.a;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Exam0121 {
  public static void main(String[] args) {

    Object obj = Proxy.newProxyInstance(
        Exam0121.class.getClassLoader(), 
        new Class<?>[] {A.class, B.class, C.class}, 
          (proxy, method, values) -> {
            System.out.println("===> " + method.getName());
            return null;
          }); // 익명 클래스 적용.

    ((A) obj).m1();
    ((B) obj).m2();
    ((C) obj).m3();
  }

}
