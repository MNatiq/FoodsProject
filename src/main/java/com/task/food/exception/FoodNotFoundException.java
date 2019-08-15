package com.task.food.exception;

public class FoodNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -2859292084648724403L;
  private final String msg;

  public FoodNotFoundException(String msg) {
    this.msg = msg;
  }

  public String getMsg() {
    return msg;
  }
}
