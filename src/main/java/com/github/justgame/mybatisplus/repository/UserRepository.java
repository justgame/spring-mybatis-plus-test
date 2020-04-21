package com.github.justgame.mybatisplus.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.justgame.mybatisplus.model.User;
import org.apache.ibatis.annotations.Insert;

/**
 * @author xcl
 * @date 2019/11/6
 */
public interface UserRepository extends BaseMapper<User> {

    @Insert("insert into user (name, age, sex, description) values (#{name}, #{age}, #{sex}, #{description})")
    void insertCustom(String name, Integer age, String description, Integer sex);
}
