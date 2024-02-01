package com.woo.checklist.dao;

import com.woo.checklist.vo.ToDo;
import java.util.List;

public interface ToDoDao {

  void add(ToDo toDo);

  int delete(int no);

  List<ToDo> findAll();

  ToDo findBy(int no);

  int update(ToDo toDo);
  
}
