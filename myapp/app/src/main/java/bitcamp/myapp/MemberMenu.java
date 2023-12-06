package bitcamp.myapp;

public class MemberMenu {

  static Member[] members = new Member[3];
  static int length = 0;

  static void MemberMenu() {
    System.out.println("[회원]");
    System.out.println("1. 등록");
    System.out.println("2. 조회");
    System.out.println("3. 변경");
    System.out.println("4. 삭제");
    System.out.println("5. 목록");
    System.out.println("0. 이전");
  }

  static void excute() {
    MemberMenu();

    while (true) {
      String input = Prompt.input("메인/회원> ");
      switch (input) {
        case "1":
          add();
          break;
        case "2":
          view();
          break;
        case "3":
          modify();
          break;
        case "4":
          delete();
          break;
        case "5":
          list();
          break;
        case "menu":
          MemberMenu();
          break;
        case "0":
          return;
        default:
          System.out.println("잘못된 메뉴 번호입니다.");
          break;
      }
    }
  }

  static void add() {
    if (length == members.length) {
      int oldSize = members.length;
      int newSize = oldSize + (oldSize / 2);
      Member[] arr = new Member[newSize];
      for (int i = 0; i < oldSize; i++) {
        arr[i] = members[i];
      }
      members = arr;

    }

    System.out.println("회원 등록:");

    Member member = new Member();
    member.name = Prompt.input("이름은? ");
    member.age = Prompt.input("나이는? ");
    member.gender = Prompt.input("성별은? ");
    members[length++] = member;
  }

  static void view() {
    System.out.println("회원 조회:");
    int index = Integer.parseInt(Prompt.input("번호? "));
    if (index < 0 || index >= length) {
      System.out.println("회원 번호가 유효하지 않습니다.");
      return;
    }
    Member member = members[index];
    System.out.printf("이름: %s\n", member.name);
    System.out.printf("나이: %s\n", member.age);
    System.out.printf("성별: %s\n", member.gender);
  }

  static void modify() {
    System.out.println("회원 변경:");
    int index = Integer.parseInt(Prompt.input("번호? "));
    if (index < 0 || index >= length) {
      System.out.println("회원 번호가 유효하지 않습니다.");
      return;
    }

    Member member = members[index];
    member.name = Prompt.input("이름(%s)은? ", member.name);
    member.age = Prompt.input("나이(%s)는? ", member.age);
    member.gender = Prompt.input("성별(%s)은? ", member.gender);
  }

  static void delete() {
    System.out.println("회원 삭제:");
    int index = Integer.parseInt(Prompt.input("번호? "));
    if (index < 0 || index >= length) {
      System.out.println("회원 번호가 유효하지 않습니다.");
      return;
    }

    for (int i = index; i < (length - 1); i++) {
      members[i] = members[i + 1];
    }
    length--;
    members[length] = null;

  }

  static void list() {
    System.out.println("회원 목록:");
    System.out.printf("%-10s\t%-10s\t%-10s\n", "이름", "나이", "성별");
    for (int i = 0; i < length; i++) {
      Member member = members[i];
      System.out.printf("%-10s\t%-10s\t%-10s\n", member.name, member.age, member.gender);
    }
  }
}
