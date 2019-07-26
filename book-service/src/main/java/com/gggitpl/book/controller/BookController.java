package com.gggitpl.book.controller;

import com.gggitpl.book.model.Book;
import com.gggitpl.book.model.Rating;
import com.gggitpl.book.service.RatingService;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/books")
public class BookController {

  @Autowired
  private RatingService ratingService;

  private List<Book> bookList = Arrays.asList(
      new Book(1L, "Baeldung goes to the market", "Tim Schimandle"),
      new Book(2L, "Baeldung goes to the park", "Slavisa")
  );

  @GetMapping
  public List<Book> findAll() {
    return bookList;
  }

  @GetMapping("/{bookId}")
  public Book getBook(@PathVariable Long bookId) {
    return bookList.stream().filter(book -> book.getId().equals(bookId)).findFirst().orElse(null);
  }

  @GetMapping("/rating/{bookId}")
  public List<Rating> rating(@PathVariable Long bookId) {
    List<Rating> ratings = ratingService.getByBookId(bookId);
    log.debug("bookId={} - {}", bookId, ratings);
    return ratings;
  }

}
