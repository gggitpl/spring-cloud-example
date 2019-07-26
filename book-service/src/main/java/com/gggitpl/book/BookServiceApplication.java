package com.gggitpl.book;

import com.gggitpl.book.config.FeignErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class BookServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(BookServiceApplication.class, args);
  }
}
