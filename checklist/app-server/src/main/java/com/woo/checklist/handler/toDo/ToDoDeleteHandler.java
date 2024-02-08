package com.woo.checklist.handler.toDo;

import com.woo.checklist.dao.ToDoDao;
import com.woo.menu.AbstractMenuHandler;
import com.woo.util.Prompt;

public class ToDoDeleteHandler extends AbstractMenuHandler {

  private ToDoDao toDoDao;

  public ToDoDeleteHandler(ToDoDao toDoDao, Prompt prompt) {
    super(prompt);
    this.toDoDao = toDoDao;
  }

  @Override
  protected void action() {
    try {
      int no = this.prompt.inputInt("번호? ");
      if (toDoDao.delete(no) == 0) {
        System.out.println("할일 번호가 유효하지 않습니다!");
      } else {
        System.out.println("할일을 완료했습니다.");
      }

    } catch (Exception e) {
      System.out.println("완료를 실행하는데 오류 발생!");
    }
  }
}
