package bitcamp.myapp.menu;

import bitcamp.util.Prompt;

public class MenuItem implements Menu {

  String title;
  Prompt prompt;

  public MenuItem(String title) {
    this.title = title;
  }

  public void execute(Prompt prompt) {
    System.out.printf("%s입니다.\n", this.title);
  }

  public String getTitle() {
    return title;
  }
}
