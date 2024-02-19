package com.woo.checklist.dao.mysql;

import com.woo.checklist.dao.DaoException;
import com.woo.checklist.dao.ToDoDao;
import com.woo.checklist.vo.ToDo;
import com.woo.util.DBConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ToDoDaoImpl implements ToDoDao {

  DBConnectionPool connectionPool;

  public ToDoDaoImpl(DBConnectionPool connectionPool) {
    this.connectionPool = connectionPool;
  }

  @Override
  public void add(ToDo toDo) {

    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
            "insert into todo(title,content,deadline,level) values(?,?,?,?)");
    ) {

      pstmt.setString(1, toDo.getTitle());
      pstmt.setString(2, toDo.getContent());
      pstmt.setDate(3, toDo.getDeadLine());
      pstmt.setInt(4, toDo.getLevel());

      pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {

    try {
      try (Connection con = connectionPool.getConnection();
          PreparedStatement pstmt1 = con.prepareStatement("delete from todo where no=?");
          PreparedStatement pstmt2 = con.prepareStatement("alter table todo auto_increment=1")) {

        pstmt1.setInt(1, no);

        int a = pstmt1.executeUpdate();
        pstmt2.executeUpdate();
        return a;
      }
    } catch (Exception e) {
      throw new DaoException("SQL:데이터 삭제 오류", e);
    }
  }

  @Override
  public List<ToDo> findAll() {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
            "select no,title,content,deadline,p.priority from todo join priority p on todo.level = p.level");
        ResultSet rs = pstmt.executeQuery()) {

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
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
            "select no,title,content,deadline,todo.level,p.priority from todo join priority p on todo.level=p.level where no=?")) {

      pstmt.setInt(1, no);

      ResultSet rs = pstmt.executeQuery();

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
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
            "update todo set title=?, content=?, deadline=?, level=? where no=?")) {

      pstmt.setString(1, toDo.getTitle());
      pstmt.setString(2, toDo.getContent());
      pstmt.setDate(3, toDo.getDeadLine());
      pstmt.setInt(4, toDo.getLevel());
      pstmt.setInt(5, toDo.getNo());

      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("SQL:데이터 변경 오류", e);
    }
  }
}


