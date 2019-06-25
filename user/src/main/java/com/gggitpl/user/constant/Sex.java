package com.gggitpl.user.constant;

import static java.util.stream.Collectors.toMap;

import com.baomidou.mybatisplus.annotation.EnumValue;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public enum Sex {

  UNKNOWN(0, "未知"), MAN(1, "男"), GIRL(2, "女");

  @EnumValue
  private final Integer code;

  private final String value;

  public Integer getCode() {
    return code;
  }

  public String getValue() {
    return value;
  }

  Sex(Integer code, String value) {
    this.code = code;
    this.value = value;
  }

  private static final Map<String, Sex> STRING_TO_ENUM = Stream.of(values())
      .collect(toMap(Sex::getValue, sex -> sex));

  public static Optional<Sex> fromString(String string) {
    return Optional.ofNullable(STRING_TO_ENUM.get(string));
  }

}
