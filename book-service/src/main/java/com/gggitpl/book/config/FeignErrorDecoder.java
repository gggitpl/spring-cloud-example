package com.gggitpl.book.config;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FeignErrorDecoder implements ErrorDecoder {
  @Override
  public Exception decode(String s, Response response) {
    switch (response.status()) {
      case 400:
        return new ResponseStatusException(HttpStatus.BAD_REQUEST);
      case 404:
        return new ResponseStatusException(HttpStatus.NOT_FOUND);
      default:
        return new Exception("Generic error");
    }
  }
}
