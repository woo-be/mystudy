package com.woo.checklist.handler.toDo;

import com.woo.checklist.dao.ToDoDao;
import com.woo.checklist.vo.ToDo;
import com.woo.menu.AbstractMenuHandler;
import com.woo.util.Prompt;

public class ToDoAddHandler extends AbstractMenuHandler {

  private ToDoDao toDoDao;


  public ToDoAddHandler(ToDoDao toDoDao, Prompt prompt) {
    super(prompt);
    this.toDoDao = toDoDao;
  }

  @Override
  protected void action() {
    try {
      ToDo toDo = new ToDo();
      toDo.setTitle(this.prompt.input("이름? "));
      toDo.setContent(this.prompt.input("내용? "));
      toDo.setDeadLine(this.prompt.inputDate("기한?(예: 2023-12-25) "));

      toDoDao.add(toDo);

    } catch (Exception e) {
      System.out.println("할일 입력 중 오류 발생!");
      System.out.println("다시 시도하시기 바랍니다.");
    }
  }
}
