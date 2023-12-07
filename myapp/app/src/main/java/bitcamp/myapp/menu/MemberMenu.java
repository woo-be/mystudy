package bitcamp.myapp.menu;

import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;

public class MemberMenu {

  Prompt prompt;
  String title;
  Member[] members = new Member[3];
  int length = 0;

  public MemberMenu(String title, Prompt prompt) {
    this.title = title;
    this.prompt = prompt;
  }

  void printMenu() {
    System.out.printf("[%s]\n", this.title);
    System.out.println("1. 등록");
    System.out.println("2. 조회");
    System.out.println("3. 변경");
    System.out.println("4. 삭제");
    System.out.println("5. 목록");
    System.out.println("0. 이전");
  }

  void execute() {
    printMenu();

    while (true) {
      String input = this.prompt.input("메인/%s> ", this.title);
      switch (input) {
        case "1":
          this.add();
          break;
        case "2":
          this.view();
          break;
        case "3":
          this.modify();
          break;
        case "4":
          this.delete();
          break;
        case "5":
          this.list();
          break;
        case "0":
          return;
        case "menu":
          printMenu();
          break;
        default:
          System.out.println("잘못된 메뉴 번호입니다.");
          break;
      }
    }
  }

  void delete() {
    System.out.println("회원 삭제:");

    int index = this.prompt.inputInt("번호? ");
    if (index < 0 || index >= this.length) {
      System.out.println("회원 번호가 유효하지 않습니다.");
      return;
    }
    for (int i = index; i < (this.length - 1); i++) {
      this.members[index] = this.members[index + 1];
    }

    this.members[this.length - 1] = null;
  }

  void add() {
    System.out.println("회원 등록:");

    if (this.length == this.members.length) {
      int oldSize = this.length;
      int newSize = oldSize + (oldSize / 2);
      Member[] arr = new Member[newSize];

      for (int i = 0; i < oldSize; i++) {
        arr[i] = this.members[i];
      }
      this.members = arr;
    }
    Member member = new Member();
    member.email = this.prompt.input("이메일? ");
    member.name = this.prompt.input("이름? ");
    member.password = this.prompt.input("암호? ");
    member.createdDate = this.prompt.input("가입일? ");
    this.members[this.length] = member;
    this.length++;
  }

  void view() {
    System.out.println("회원 조회:");

    int index = this.prompt.inputInt("번호? ");
    if (index < 0 || index >= this.length) {
      System.out.println("회원 번호가 유효하지 않습니다.");
      return;
    }

    Member member = this.members[index];
    System.out.printf("이메일: %s\n", member.email);
    System.out.printf("이름: %s\n", member.name);
    System.out.printf("가입일: %s\n", member.createdDate);
  }

  void modify() {
    System.out.println("회원 변경:");

    int index = this.prompt.inputInt("번호? ");
    if (index < 0 || index >= this.length) {
      System.out.println("회원 번호가 유효하지 않습니다.");
      return;
    }

    Member member = this.members[index];
    member.email = this.prompt.input("이메일(%s)? ", member.email);
    member.name = this.prompt.input("이름(%s)? ", member.name);
    member.password = this.prompt.input("암호? ", member.password);
    member.createdDate = this.prompt.input("가입일(%s)? ", member.createdDate);
  }

  void list() {
    System.out.printf("%-10s\t%-10s\t%-10s\n", "Email", "Name", "CreatedDate");

    for (int i = 0; i < this.length; i++) {
      Member member = this.members[i];
      System.out.printf("%-10s\t%-10s\t%-10s\n", member.email, member.name, member.createdDate);
    }
  }
}
