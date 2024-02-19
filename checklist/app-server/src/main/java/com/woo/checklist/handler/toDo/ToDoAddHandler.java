package com.woo.checklist.handler.toDo;

import com.woo.checklist.dao.ToDoDao;
import com.woo.checklist.vo.ToDo;
import com.woo.menu.AbstractMenuHandler;
import com.woo.util.Prompt;
import com.woo.util.TransactionManager;

public class ToDoAddHandler extends AbstractMenuHandler {

  private TransactionManager txManager;
  private ToDoDao toDoDao;

  public ToDoAddHandler(TransactionManager txManager, ToDoDao toDoDao) {
    this.txManager = txManager;
    this.toDoDao = toDoDao;
  }

  @Override
  protected void action(Prompt prompt) {
    try {
      ToDo toDo = new ToDo();
      toDo.setTitle(prompt.input("제목? "));
      toDo.setContent(prompt.input("내용? "));
      toDo.setDeadLine(prompt.inputDate("기한?(예: 2023-12-25) "));
      toDo.setLevel(prompt.inputInt("우선순위?(1-3 중 입력) "));

      txManager.startTransaction();

      toDoDao.add(toDo);

      txManager.commit();

    } catch (Exception e) {
      try {
        txManager.rollback();
      } catch (Exception e2) {
      }
      prompt.println("할일 입력 중 오류 발생!");
      prompt.println("다시 시도하시기 바랍니다.");
      e.printStackTrace();
    }
  }
}
