package com.gggitpl.user.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gggitpl.user.constant.Sex;
import com.gggitpl.user.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest//@SpringBootTest注解会创建整个上下文
@AutoConfigureMockMvc
@Slf4j
public class UserControllerAppIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void whenTestApp_thenEmptyResponse() throws Exception {
    this.mockMvc.perform(get("/users"))
        .andExpect(status().isOk())
        .andReturn();
  }

  @Test
  public void create() throws Exception {
    MockHttpServletRequestBuilder requestBuilder = post("/users")
        .content(new ObjectMapper()
            .writeValueAsBytes(User.builder().name("张三").age(10).sex(Sex.MAN).build()))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON);
    MvcResult mvcResult = this.mockMvc.perform(requestBuilder)
        .andExpect(status().isCreated())
        .andReturn();
    log.debug("{}", mvcResult.getResponse().getContentAsString());
  }

  @Test
  public void findById() throws Exception {
    this.mockMvc.perform(get("/123"))
        .andExpect(MockMvcResultMatchers.status().isNotFound())
        .andDo(result -> result.getResponse().getContentAsString());
  }
}
