// character stream - 문자 단위로 읽기
package com.eomcs.io.ex03;

import java.io.FileReader;

public class Exam0130 {

  public static void main(String[] args) throws Exception {
    FileReader in = new FileReader("sample/utf8.txt"); // 41 42 b0 a1 b0 a

    int ch;

    while ((ch = in.read()) != -1) {
      System.out.printf("%02x ", ch);
    }

    in.close();
  }
}


