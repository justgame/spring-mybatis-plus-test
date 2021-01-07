package com.github.justgame.mybatisplus.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.justgame.mybatisplus.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

/**
 * @author xcl
 * @date 2019/11/6
 */
public interface UserRepository extends BaseMapper<User> {
    @Insert("insert into user (name, age, sex, description) values (#{name}, #{age}, #{sex}, #{description})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    Integer optionsInsert(User user);

    @Insert("insert into user (name, age, sex, description) values (#{name}, #{age}, #{sex}, #{description})")
    void customInsert(String name, Integer age, String description, Integer sex);

    @Select("select * from user")
    Cursor<User> selectAllStream();

    @SelectProvider(type = SqlProvider.class, method = "selectBySelective")
    List<User> selectBySelective(User user);

    class SqlProvider {
        public static String selectBySelective(User user) {
            return new SQL() {{
                SELECT("*");
                FROM("user");
                if (user.getId() != null) {
                    WHERE("id = #{id}");
                }
                if (user.getName() != null) {
                    WHERE("name like #{name}");
                }
                if (user.getSex() != null) {
                    WHERE("sex = #{sex}");
                }
                if (user.getAge() != null) {
                    WHERE("age = #{age}");
                }
                if (user.getDescription() != null) {
                    WHERE("description = #{description}");
                }
            }}.toString();
        }
    }
}
