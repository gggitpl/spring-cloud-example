package com.gggitpl.user.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gggitpl.user.constant.Sex;
import com.gggitpl.user.model.User;
import com.gggitpl.user.service.UserService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockReset;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@Slf4j
public class UserControllerWebLayerIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserService userService;

  @Test
  public void whenTestMvcController_thenRetrieveExpectedResult() throws Exception {
    this.mockMvc.perform(get("/users"))
        .andExpect(status().isOk())
        .andReturn();
  }

  @Test
  public void create() throws Exception {
    MockHttpServletRequestBuilder requestBuilder = post("/users")
        .content(toJson(User.builder().id(1L).name("张三").age(10).sex(Sex.MAN).build()))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON);
    MvcResult mvcResult = this.mockMvc.perform(requestBuilder)
        .andExpect(status().isCreated())
        .andReturn();
    log.debug("{}", mvcResult.getResponse().getContentAsString());
  }


  private String toJson(final Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }
}
