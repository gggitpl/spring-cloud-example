package com.gggitpl.book.service;

import com.gggitpl.book.model.Rating;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "rating-service", fallback = RatingServiceFallback.class)
public interface RatingService {

  @GetMapping("/ratings/{bookId}")
  List<Rating> getByBookId(@PathVariable Long bookId);
}

