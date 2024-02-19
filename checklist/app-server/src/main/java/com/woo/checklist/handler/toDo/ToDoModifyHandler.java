package com.woo.checklist.handler.toDo;

import com.woo.checklist.dao.ToDoDao;
import com.woo.checklist.vo.ToDo;
import com.woo.menu.AbstractMenuHandler;
import com.woo.util.Prompt;

public class ToDoModifyHandler extends AbstractMenuHandler {

  private ToDoDao toDoDao;

  public ToDoModifyHandler(ToDoDao toDoDao) {
    this.toDoDao = toDoDao;
  }

  @Override
  protected void action(Prompt prompt) {
    try {
      int no = prompt.inputInt("번호? ");

      ToDo old = toDoDao.findBy(no);
      if (old == null) {
        prompt.println("할일 번호가 유효하지 않습니다!");
        return;
      }

      ToDo toDo = new ToDo();
      toDo.setNo(old.getNo());
      toDo.setTitle(prompt.input("제목(%s)? ", old.getTitle()));
      toDo.setContent(prompt.input("내용(%s)? ", old.getContent()));
      toDo.setDeadLine(prompt.inputDate("기한(%s)? ", old.getDeadLine()));
      toDo.setLevel(prompt.inputInt("우선순위(%s)? ", old.getLevel()));

      toDoDao.update(toDo);
      prompt.println("할일을 변경했습니다.");

    } catch (NumberFormatException e) {
      prompt.println("숫자를 입력하세요!");

    } catch (IllegalArgumentException e) {
      prompt.println("할일 변경 오류!");
      prompt.println("다시 시도 하세요.");

    } catch (Exception e) {
      prompt.println("실행 오류!");
      e.printStackTrace();
    }

  }
}
