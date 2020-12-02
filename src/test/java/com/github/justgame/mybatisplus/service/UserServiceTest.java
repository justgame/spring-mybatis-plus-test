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
        User user1 = new User().setName("a");
        User user2 = new User().setName("b").setAge(7);
        User user3 = new User().setName("c");

        userService.saveBatch(Lists.newArrayList(user1, user2, user3));
    }
}