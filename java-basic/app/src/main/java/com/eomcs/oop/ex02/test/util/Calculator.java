package com.eomcs.oop.ex02.test.util;

public class Calculator {

  public int result;

  public void plus(Calculator instance, int value) {
    instance.result += value;
  }

  public void minus(Calculator instance, int value) {
    instance.result -= value;
  }

  public void multiple(Calculator instance, int value) {
    instance.result *= value;
  }

  public void divide(Calculator instance, int value) {
    instance.result /= value;
  }
}
