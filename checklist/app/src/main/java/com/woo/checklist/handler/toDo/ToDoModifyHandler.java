package com.woo.checklist.handler.toDo;

import com.woo.checklist.dao.ToDoDao;
import com.woo.checklist.vo.ToDo;
import com.woo.menu.AbstractMenuHandler;
import com.woo.util.Prompt;

public class ToDoModifyHandler extends AbstractMenuHandler {

  private ToDoDao toDoDao;

  public ToDoModifyHandler(ToDoDao toDoDao, Prompt prompt) {
    super(prompt);
    this.toDoDao = toDoDao;
  }

  @Override
  protected void action() {
    try {
      int no = this.prompt.inputInt("번호? ");

      ToDo old = toDoDao.findBy(no);
      if (old == null) {
        System.out.println("할일 번호가 유효하지 않습니다!");
        return;
      }

      ToDo toDo = new ToDo();
      toDo.setNo(old.getNo());
      toDo.setTitle(this.prompt.input("이름(%s)? ", old.getTitle()));
      toDo.setContent(this.prompt.input("내용(%s)? ", old.getContent()));
      toDo.setDeadLine(this.prompt.inputDate("기한(%s)? ", old.getDeadLine()));

      toDoDao.update(toDo);
      System.out.println("할일을 변경했습니다.");

    } catch (NumberFormatException e) {
      System.out.println("숫자를 입력하세요!");

    } catch (IllegalArgumentException e) {
      System.out.println("할일 변경 오류!");
      System.out.println("다시 시도 하세요.");

    } catch (Exception e) {
      System.out.println("실행 오류!");
      e.printStackTrace();
    }

  }
}
