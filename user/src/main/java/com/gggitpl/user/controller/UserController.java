package com.gggitpl.user.controller;

import com.gggitpl.user.model.User;
import com.gggitpl.user.service.UserService;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/{id}")
  public User findById(@PathVariable Long id) {
    return userService.getById(id);
  }

  @GetMapping
  public List<User> findAll() {
    return new ArrayList<>();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public User create(@RequestBody User user) {
    userService.save(user);
    return user;
  }

  @PutMapping
  @ResponseStatus(HttpStatus.CREATED)
  public User update(@RequestBody User user) {
    return user;
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) {

  }
}
