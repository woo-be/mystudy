package com.woo.checklist.dao.mysql;

import com.woo.checklist.dao.DaoException;
import com.woo.checklist.dao.ToDoDao;
import com.woo.checklist.vo.ToDo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ToDoDaoImpl implements ToDoDao {

  Connection con;

  public ToDoDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void add(ToDo toDo) {
    try {
      Statement stmt = con.createStatement();
      stmt.executeUpdate(String.format(
          "insert into todo(title,content,deadline,level) values('%s','%s','%s',%d)",
          toDo.getTitle(), toDo.getContent(), toDo.getDeadLine(), toDo.getLevel()));

    } catch (Exception e) {
      throw new DaoException("SQL:데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try {
      Statement stmt = con.createStatement();
      int a = stmt.executeUpdate(String.format("delete from todo where no=%d", no));
      stmt.executeUpdate(("alter table todo auto_increment=1"));
      return a;

    } catch (Exception e) {
      throw new DaoException("SQL:데이터 삭제 오류", e);
    }
  }

  @Override
  public List<ToDo> findAll() {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery(
          "select no,title,content,deadline,p.priority from todo join priority p on todo.level = p.level;");

      ArrayList<ToDo> list = new ArrayList<>();

      while (rs.next()) {
        ToDo toDo = new ToDo();
        toDo.setNo(rs.getInt("no"));
        toDo.setTitle(rs.getString("title"));
        toDo.setContent(rs.getString("content"));
        toDo.setDeadLine(rs.getDate("deadline"));
        toDo.setPriority(rs.getString("priority"));

        list.add(toDo);
      }
      return list;

    } catch (Exception e) {
      throw new DaoException("SQL:데이터 가져오기 오류", e);
    }
  }

  @Override
  public ToDo findBy(int no) {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery(
          "select no,title,content,deadline,todo.level,p.priority "
              + "from todo join priority p on todo.level=p.level where no="
              + no);

      if (rs.next()) {
        ToDo toDo = new ToDo();
        toDo.setNo(rs.getInt("no"));
        toDo.setTitle(rs.getString("title"));
        toDo.setContent(rs.getString("content"));
        toDo.setDeadLine(rs.getDate("deadline"));
        toDo.setLevel(rs.getInt("level"));
        toDo.setPriority(rs.getString("priority"));

        return toDo;
      }
      return null;

    } catch (Exception e) {
      throw new DaoException("SQL:데이터 가져오기 오류", e);
    }
  }

  @Override
  public int update(ToDo toDo) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format(
          "update todo set title='%s', content='%s', deadline='%s', level=%d where no=%d",
          toDo.getTitle(), toDo.getContent(), toDo.getDeadLine(), toDo.getLevel(),
          toDo.getNo()));

    } catch (Exception e) {
      throw new DaoException("SQL:데이터 변경 오류", e);
    }
  }
}


