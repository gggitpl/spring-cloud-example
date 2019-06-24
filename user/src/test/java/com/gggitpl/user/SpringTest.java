package com.gggitpl.user;

import com.gggitpl.user.config.WebMvcConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
    classes = {WebMvcConfig.class},
    loader = AnnotationConfigContextLoader.class
)
public class SpringTest {

  @Test
  public void whenSpringContextIsInstantiated_thenNoExceptions() {

  }

}
