package bitcamp.myapp;

import java.util.Scanner;

public class App {

  static String ANSI_CLEAR = "\033[0;0m";
  static String ANSI_RED = "\033[0;31m";
  static String ANSI_BOLD_RED = "\033[1;31m";
  static String APP_TITLE = "[과제관리 시스템]";
  static String[] MENUS = {
      "1. 과제",
      "2. 게시글",
      "3. 도움말",
      ANSI_RED + "4. 종료" + ANSI_CLEAR
  };

  public static void main(String[] args) {

    printMenu();
    System.out.println('\u0041');
    java.util.Scanner keyIn = new java.util.Scanner(System.in);

    loop:
    while (true) {
      String input = prompt(keyIn);

      switch (input) {
        case "1":
          System.out.println("과제입니다.");
          break;
        case "2":
          System.out.println("게시글입니다.");
          break;
        case "3":
          System.out.println("도움말입니다.");
          break;
        case "4":
          System.out.println("종료합니다.");
          break loop;
        case "menu":
          printMenu();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
          break;
      }
    }
    keyIn.close();
  }

  static void printMenu() {
    System.out.println(ANSI_BOLD_RED + APP_TITLE + ANSI_CLEAR);
    System.out.println();
    for (String menu : MENUS) {
      System.out.println(menu);
    }
  }

  static String prompt(Scanner keyIn) {
    System.out.print("> ");
    return keyIn.nextLine();
  }
}