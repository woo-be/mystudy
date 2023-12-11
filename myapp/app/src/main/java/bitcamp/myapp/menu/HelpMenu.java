package bitcamp.myapp.menu;

import bitcamp.util.Prompt;

public class HelpMenu implements Menu {

  String title;
  Prompt prompt;

  public HelpMenu(String title, Prompt prompt) {
    this.title = title;
    this.prompt = prompt;
  }

  public String getTitle() {
    return null;
  }

  public void execute(Prompt prompt) {
    System.out.printf("[%s]\n", this.title);
    System.out.println("도움말입니다.");
  }
}
