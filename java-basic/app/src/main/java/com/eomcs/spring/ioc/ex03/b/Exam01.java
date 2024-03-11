// 생성자의 파라미터 값을 지정하는 방법 II
package com.eomcs.spring.ioc.ex03.b;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam01 {

  public static void main(String[] args) {
    ApplicationContext iocContainer = new ClassPathXmlApplicationContext(//
        "com/eomcs/spring/ioc/ex03/b/application-context.xml");

    System.out.println(iocContainer.getBean("c1"));
    // SpringUtils.printBeanNames(iocContainer);
  }

}


