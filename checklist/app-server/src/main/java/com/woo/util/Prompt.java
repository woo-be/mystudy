package com.woo.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Date;
import java.util.Stack;

public class Prompt implements AutoCloseable {

  Stack<String> breadcrumb = new Stack<>();

  private DataInputStream in;
  private DataOutputStream out;
  private StringWriter stringWriter = new StringWriter();
  private PrintWriter writer = new PrintWriter(stringWriter);

  public Prompt(DataInputStream in, DataOutputStream out) {
    this.in = in;
    this.out = out;
  }

  public String input(String str, Object... args) {
    try {
      printf(str, args);
      end();
      return in.readUTF();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public int inputInt(String title, Object... args) {
    return Integer.parseInt(this.input(title, args));
  }

  public float inputFloat(String title, Object... args) {
    return Float.parseFloat(this.input(title, args));
  }

  public boolean inputBoolean(String title, Object... args) {
    return Boolean.parseBoolean(this.input(title, args));
  }

  public Date inputDate(String title, Object... args) {
    return Date.valueOf(this.input(title, args));
  }

//  public void close() {
//    this.keyIn.close();
//  }

  public void print(String str) {
    writer.print(str);
  }

  public void println(String str) {
    writer.println(str);
  }

  public void printf(String str, Object... args) {
    writer.printf(str, args);
  }

  public void end() throws Exception {
    StringBuffer buf = stringWriter.getBuffer();
    String content = buf.toString();

    buf.setLength(0);

    out.writeUTF(content);
  }

  public void close() throws Exception {
    writer.close();
    stringWriter.close();
  }

  public void pushPath(String path) {
    breadcrumb.push(path);
  }

  public String popPath() {
    return breadcrumb.pop();
  }

  public String getFullPath() {
    return String.join("/", breadcrumb.toArray(new String[0]));
  }
}
