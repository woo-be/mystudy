package com.woo.checklist.handler.toDo;

import com.woo.checklist.dao.ToDoDao;
import com.woo.menu.AbstractMenuHandler;
import com.woo.util.Prompt;

public class ToDoDeleteHandler extends AbstractMenuHandler {

  private ToDoDao toDoDao;

  public ToDoDeleteHandler(ToDoDao toDoDao) {
    this.toDoDao = toDoDao;
  }

  @Override
  protected void action(Prompt prompt) {
    try {
      int no = prompt.inputInt("번호? ");
      if (toDoDao.delete(no) == 0) {
        prompt.println("할일 번호가 유효하지 않습니다!");
      } else {
        prompt.println("할일을 완료했습니다.");
      }

    } catch (Exception e) {
      prompt.println("완료를 실행하는데 오류 발생!");
    }
  }
}
