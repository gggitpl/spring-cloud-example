package com.gggitpl.user.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.gggitpl.user.constant.Sex;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName
public class User {

  private Long id;
  private String name;
  private Integer age;
  private Sex sex;
  @Default
  private Long createTime = System.currentTimeMillis();
  @Default
  private Long updateTime = System.currentTimeMillis();

}
