package com.woo.checklist.handler.toDo;

import com.woo.checklist.dao.ToDoDao;
import com.woo.checklist.vo.ToDo;
import com.woo.menu.AbstractMenuHandler;
import com.woo.util.Prompt;

public class ToDoViewHandler extends AbstractMenuHandler {

  private ToDoDao toDoDao;

  public ToDoViewHandler(ToDoDao toDoDao, Prompt prompt) {
    super(prompt);
    this.toDoDao = toDoDao;
  }

  @Override
  protected void action() {
    try {
      int no = this.prompt.inputInt("번호? ");
      ToDo toDo = toDoDao.findBy(no);
      if (toDo == null) {
        System.out.println("할일 번호가 유효하지 않습니다!");
        return;
      }

      System.out.printf("번호: %s\n", toDo.getNo());
      System.out.printf("이름: %s\n", toDo.getTitle());
      System.out.printf("내용: %s\n", toDo.getContent());
      System.out.printf("기한: %s\n", toDo.getDeadLine());

    } catch (Exception e) {
      System.out.println("조회 오류!");
    }
  }

}
