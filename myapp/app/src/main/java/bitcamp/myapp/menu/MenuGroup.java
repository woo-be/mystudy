package bitcamp.myapp.menu;

import bitcamp.util.Prompt;

public class MenuGroup implements Menu {

  String title;
  Menu[] menus = new Menu[10];
  int menuSize;

  public MenuGroup(String title) {
    this.title = title;
  }

  public void execute(Prompt prompt) {
    printMenu();

    while (true) {
      String input = prompt.input("%s> ", this.title);

      if (input.equals("menu")) {
        this.printMenu();
        continue;
      } else if (input.equals("0")) {
        break;
      }

      int menuNo = Integer.parseInt(input);
      if (menuNo < 1 || menuNo > this.menuSize) {
        System.out.println("메뉴 번호가 옳지 않습니다.");
        continue;
      }

      this.menus[menuNo - 1].execute(prompt);
    }
  }

  public void printMenu() {
    System.out.printf("[%s]\n", this.title);

    for (int i = 0; i < this.menuSize; i++) {
      System.out.printf("%d. %s\n", (i + 1), menus[i].getTitle());
    }
  }

  public void add(Menu menu) {
    if (this.menuSize == this.menus.length) {
      int oldSize = this.menus.length;
      int newSize = oldSize + (oldSize >> 1);

      Menu[] arr = new Menu[newSize];
      for (int i = 0; i < oldSize; i++) {
        arr[i] = this.menus[i];
      }

      this.menus = arr;
    }
    this.menus[this.menuSize++] = menu;
  }

  public String getTitle() {
    return this.title;
  }
}
