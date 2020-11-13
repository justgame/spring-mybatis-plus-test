package com.github.justgame.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.justgame.mybatisplus.model.User;
import com.github.justgame.mybatisplus.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * @author xiecongle
 * @date 2020/11/13
 */
@Service
public class UserService extends ServiceImpl<UserRepository, User> implements IService<User> {
}
