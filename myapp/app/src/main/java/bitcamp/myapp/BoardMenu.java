package bitcamp.myapp;

import bitcamp.myapp.vo.Board;

public class BoardMenu {

  static void printMenu() {
    System.out.println("[게시글]");
    System.out.println("1. 등록");
    System.out.println("2. 조회");
    System.out.println("3. 변경");
    System.out.println("4. 삭제");
    System.out.println("0. 이전");
  }

  static void execute() {
    Board board = new Board();

    printMenu();

    while (true) {
      String input = Prompt.input("메인/게시글> ");
      switch (input) {
        case "1":
          board.add();
          break;
        case "2":
          board.view();
          break;
        case "3":
          board.modify();
          break;
        case "4":
          board.delete();
          break;
        case "0":
          return;
        case "menu":
          printMenu();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다!");
      }
    }
  }

}
