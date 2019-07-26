package com.gggitpl.book.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rating {

  private Long id;
  private Long bookId;
  private int stars;
}
