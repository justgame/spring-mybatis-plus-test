package com.github.justgame.mybatisplus.service;

import com.github.justgame.mybatisplus.model.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author xiecongle
 * @date 2020/11/13
 */
@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void testBatchSave() {
        User user1 = new User().setName("1").setSex(1);
        User user2 = new User().setName("2").setSex(2);
        User user3 = new User().setName("3").setSex(3);

        userService.saveBatch(Lists.newArrayList(user1, user2, user3));
    }
}