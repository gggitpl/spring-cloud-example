package com.gggitpl.book.service;

import com.gggitpl.book.model.Rating;
import java.util.Collections;
import java.util.List;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class RatingServiceFallback implements RatingService {

  @Override
  public List<Rating> getByBookId(Long bookId) {
    return Collections.EMPTY_LIST;
  }
}
