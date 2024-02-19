package com.woo.checklist.handler.toDo;

import com.woo.checklist.dao.ToDoDao;
import com.woo.checklist.vo.ToDo;
import com.woo.menu.AbstractMenuHandler;
import com.woo.util.Prompt;
import java.util.List;

public class ToDoListHandler extends AbstractMenuHandler {

  private ToDoDao toDoDao;

  public ToDoListHandler(ToDoDao toDoDao) {
    this.toDoDao = toDoDao;
  }

  @Override
  protected void action(Prompt prompt) {
    prompt.printf("%-2s\t%-23s\t%-8s\t%s\n", "번호", "할일", "기한", "우선순위");

    List<ToDo> list = toDoDao.findAll();

    for (ToDo toDo : list) {
      int titleSize = 25 - getKorCnt(toDo.getTitle());

//      System.out.printf("%-4s\t%-25s%s\n",
//          String.valueOf(toDo.getNo()),
//          toDo.getTitle(),
//          toDo.getDeadLine());
      prompt.printf(
          String.format("%-4d\t%%-" + titleSize + "s\t%s\t%s\n", toDo.getNo(), toDo.getDeadLine(),
              toDo.getPriority()),
          toDo.getTitle());
    }
  }

  private static int getKorCnt(String kor) {
    int cnt = 0;
    for (int i = 0; i < kor.length(); i++) {
      if (kor.charAt(i) >= '가' && kor.charAt(i) <= '힣') {
        cnt++;
      }
    }
    return cnt;
  }

}
