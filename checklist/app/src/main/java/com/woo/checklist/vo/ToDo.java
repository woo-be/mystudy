package com.woo.checklist.vo;

import java.io.Serializable;
import java.sql.Date;

public class ToDo implements Serializable {

  private int no;
  private String title;
  private String content;
  private Date deadLine;

  @Override
  public String toString() {
    return "checkList{" +
        "no=" + no +
        ", title='" + title + '\'' +
        ", content='" + content + '\'' +
        ", deadLine=" + deadLine +
        '}';
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getDeadLine() {
    return deadLine;
  }

  public void setDeadLine(Date deadLine) {
    this.deadLine = deadLine;
  }
}
