package com.gggitpl.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gggitpl.user.mapper.UserMapper;
import com.gggitpl.user.model.User;
import com.gggitpl.user.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


}
