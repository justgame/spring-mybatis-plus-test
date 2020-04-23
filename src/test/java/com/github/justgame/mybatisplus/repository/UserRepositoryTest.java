package com.github.justgame.mybatisplus.repository;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.justgame.mybatisplus.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
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

    @Test
    void testGetOne() {
        User user = userRepository.selectOne(Wrappers.query(new User().setName("test")));
        System.out.println(user);
    }

    @Test
    void testCustomInsert() {
        userRepository.customInsert("test insert custom", 18, "test insert custom", 0);
    }

    @Test
    void testDuplicateKey() {
        User user = new User();
        user.setName("xcl").setSex(1).setAge(18).setDescription("test duplicate key");
        userRepository.insert(user);

        User user2 = new User();
        BeanUtils.copyProperties(user, user2);
        userRepository.insert(user2);
        // 出现DuplicateKeyException
    }

    @Test
    void testOptionsInsert() {
        // 此方法得出使用mybatis的@Options注解，可以实现将自增id设置回参数对象中
        User user = new User();
        user.setName("11").setSex(0).setAge(17).setDescription("test insert with options annotation");
        System.out.println(userRepository.optionsInsert(user));
        System.out.println(user.getId());
    }

    @Test
    void testSelectBySelective() {
        User user = new User();
        user.setName("xcl").setAge(18);
        System.out.println(userRepository.selectBySelective(user));
    }
}