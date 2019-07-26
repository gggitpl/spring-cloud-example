package com.gggitpl.rating.controller;

import com.gggitpl.rating.model.Rating;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RatingController {

  private List<Rating> ratingList = Arrays.asList(
      new Rating(1L, 1L, 2),
      new Rating(2L, 1L, 3),
      new Rating(3L, 2L, 4),
      new Rating(4L, 2L, 5)
  );

  @GetMapping("/{bookId}")
  public List<Rating> findByBookId(@PathVariable Long bookId) {
    return bookId == null || bookId.equals(0L) ? Collections.EMPTY_LIST
        : ratingList.stream().filter(rating -> rating.getBookId().equals(bookId)).collect(
            Collectors.toList());
  }

  @GetMapping
  public List<Rating> findAll() {
    return ratingList;
  }
}
