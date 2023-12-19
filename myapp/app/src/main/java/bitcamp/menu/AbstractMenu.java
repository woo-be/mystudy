package bitcamp.menu;

public abstract class AbstractMenu implements Menu {

  String title;

  public AbstractMenu(String title) {
    this.title = title;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
