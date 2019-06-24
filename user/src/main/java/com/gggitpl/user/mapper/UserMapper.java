package com.gggitpl.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gggitpl.user.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper extends BaseMapper<User> {

}
