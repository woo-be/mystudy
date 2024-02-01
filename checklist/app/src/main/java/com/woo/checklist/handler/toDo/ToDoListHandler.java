package com.woo.checklist.handler.toDo;

import com.woo.checklist.dao.ToDoDao;
import com.woo.checklist.vo.ToDo;
import com.woo.menu.AbstractMenuHandler;
import com.woo.util.Prompt;
import java.util.List;

public class ToDoListHandler extends AbstractMenuHandler {

  private ToDoDao toDoDao;

  public ToDoListHandler(ToDoDao toDoDao, Prompt prompt) {
    super(prompt);
    this.toDoDao = toDoDao;
  }

  @Override
  protected void action() {
    System.out.printf("%-4s\t%-20s\t%s\n", "번호", "할일", "기한");

    List<ToDo> list = toDoDao.findAll();

    for (ToDo toDo : list) {
      System.out.printf("%-4d\t%-20s\t%s\n",
          toDo.getNo(),
          toDo.getTitle(),
          toDo.getDeadLine());
    }
  }
}
