package bitcamp.myapp;

import bitcamp.myapp.menu.MenuGroup;
import bitcamp.myapp.menu.MenuItem;
import bitcamp.util.Prompt;

public class App {

  public static void main(String[] args) {
    Prompt prompt = new Prompt(System.in);
    //    new MainMenu(prompt).execute();

    MenuGroup mainMenu = new MenuGroup("메인");

    MenuGroup assignmentMenu = new MenuGroup("과제");
    
    assignmentMenu.add(new MenuItem("등록"));
    assignmentMenu.add(new MenuItem("조회"));
    assignmentMenu.add(new MenuItem("변경"));
    assignmentMenu.add(new MenuItem("삭제"));
    assignmentMenu.add(new MenuItem("목록"));
    mainMenu.add(assignmentMenu);

    MenuGroup boardMenu = new MenuGroup("게시판");

    boardMenu.add(new MenuItem("등록"));
    boardMenu.add(new MenuItem("조회"));
    boardMenu.add(new MenuItem("변경"));
    boardMenu.add(new MenuItem("삭제"));
    boardMenu.add(new MenuItem("목록"));
    mainMenu.add(boardMenu);

    mainMenu.execute(prompt);

    prompt.close();
  }
}
