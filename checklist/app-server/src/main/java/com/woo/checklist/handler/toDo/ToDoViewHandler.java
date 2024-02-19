package com.woo.checklist.handler.toDo;

import com.woo.checklist.dao.ToDoDao;
import com.woo.checklist.vo.ToDo;
import com.woo.menu.AbstractMenuHandler;
import com.woo.util.Prompt;

public class ToDoViewHandler extends AbstractMenuHandler {

  private ToDoDao toDoDao;

  public ToDoViewHandler(ToDoDao toDoDao) {
    this.toDoDao = toDoDao;
  }

  @Override
  protected void action(Prompt prompt) {
    try {
      int no = prompt.inputInt("번호? ");
      ToDo toDo = toDoDao.findBy(no);
      if (toDo == null) {
        prompt.println("할일 번호가 유효하지 않습니다!");
        return;
      }

      prompt.printf("번호: %s\n", toDo.getNo());
      prompt.printf("제목: %s\n", toDo.getTitle());
      prompt.printf("내용: %s\n", toDo.getContent());
      prompt.printf("기한: %s\n", toDo.getDeadLine());
      prompt.printf("우선순위: %s\n", toDo.getPriority());

    } catch (Exception e) {
      prompt.println("조회 오류!");
    }
  }

}
