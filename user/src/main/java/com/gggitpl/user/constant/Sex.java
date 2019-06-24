package com.gggitpl.user.constant;

public enum Sex {

  UNKNOWN(0, "未知"), MAN(1, "男"), GIRL(2, "女");

  private Integer value;

  private String message;

  Sex(Integer value, String message) {
    this.value = value;
    this.message = message;
  }

}
