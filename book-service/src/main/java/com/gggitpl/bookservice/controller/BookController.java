package com.gggitpl.bookservice.controller;

import com.gggitpl.bookservice.model.Book;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

  private List<Book> bookList = Arrays.asList(
      new Book(1L, "Baeldung goes to the market", "Tim Schimandle"),
      new Book(2L, "Baeldung goes to the park", "Slavisa")
  );

  @GetMapping
  public List<Book> findAll() {
    return bookList;
  }

  @GetMapping("/{id}")
  public Book findById(@PathVariable Long id) {
    return bookList.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
  }

}
