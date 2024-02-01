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
          "insert into assignments(title,content,deadline) values('%s','%s','%s')",
          toDo.getTitle(), toDo.getContent(), toDo.getDeadLine()));

    } catch (Exception e) {
      throw new DaoException("SQL:데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(
          String.format("delete from assignments where assignment_no=%d", no));

    } catch (Exception e) {
      throw new DaoException("SQL:데이터 삭제 오류", e);
    }
  }

  @Override
  public List<ToDo> findAll() {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from assignments");

      ArrayList<ToDo> list = new ArrayList<>();

      while (rs.next()) {
        ToDo toDo = new ToDo();
        toDo.setNo(rs.getInt("assignment_no"));
        toDo.setTitle(rs.getString("title"));
        toDo.setContent(rs.getString("content"));
        toDo.setDeadLine(rs.getDate("deadline"));

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
      ResultSet rs = stmt.executeQuery("select * from assignments where assignment_no=" + no);

      ArrayList<ToDo> list = new ArrayList<>();

      if (rs.next()) {
        ToDo toDo = new ToDo();
        toDo.setNo(rs.getInt("assignment_no"));
        toDo.setTitle(rs.getString("title"));
        toDo.setContent(rs.getString("content"));
        toDo.setDeadLine(rs.getDate("deadline"));

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
          "update assignments set title='%s', content='%s', deadline='%s' where assignment_no=%d",
          toDo.getTitle(), toDo.getContent(), toDo.getDeadLine(),
          toDo.getNo()));

    } catch (Exception e) {
      throw new DaoException("SQL:데이터 변경 오류", e);
    }
  }
}


