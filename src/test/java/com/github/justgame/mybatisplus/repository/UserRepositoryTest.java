package com.github.justgame.mybatisplus.repository;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.justgame.mybatisplus.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author xcl
 * @date 2019/11/6
 */
@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void myFirstTest() {
        assertEquals(2, 1 + 1);
    }

    @Test
    void testList() {
        System.out.println(userRepository.selectList(null));
    }

    @Test
    void testPage() {
        Page<User> page = new Page<>(1, 2);
        System.out.println(userRepository.selectPage(page, null).getRecords().size());
    }

    @Test
    void testUpdate() {
        User user = new User();
        user.setId(1L).setName("testtesttest").setAge(111);
        userRepository.update(user, Wrappers.<User>lambdaUpdate().set(User::getSex, null).eq(User::getId, user.getId()));
    }
}