package com.eomcs.lang.ex07;

import java.util.Scanner;

// # 메서드 : 사용 전
//
public class Exam001 {

  static void printSpaces(int spaceLen) {
    int spaceCnt = 1;
    while (spaceCnt <= spaceLen) {
      System.out.print(" ");
      spaceCnt++;
    }
  }

  static void printStars(int starLen) {
    int starCnt = 1;
    while (starCnt <= starLen) {
      System.out.print("*");
      starCnt++;
    }
  }

  static int prompt(String title) {
    Scanner keyScan = new Scanner(System.in);
    System.out.print(title);
    int len = keyScan.nextInt();
    keyScan.close();

    return len;
  }

  static int computeSpaces(int len, int starLen) {
    return (len - starLen) / 2;
  }

  public static void main(String[] args) {

    int len = prompt("밑변의 길이? ");

    for (int starLen = 1; starLen <= len; starLen += 2) {
      printSpaces(computeSpaces(len, starLen));
      printStars(starLen);
      // 출력 줄 바꾸기
      System.out.println();
    }
  }
}
