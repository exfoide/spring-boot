package com.jasper.mapper;

import com.jasper.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Jasper on 2017/5/4.
 */
@Mapper
public interface UserMapper {
    //使用Map
    @Insert("insert into user(name, age) values(#{name, jdbcType = VARCHAR}, #{age, jdbcType = INTEGER)")
    int insertByMap(Map<String, Object> map);

    // 使用对象
    @Insert("insert into user(name, age) values(#{name}, #{age})")
    int insertByUser(User user);

    @Select("SELECT * FROM user WHERE name = #{name}")
    User findByName(@Param("name") String name);

    @Insert("INSERT INTO user(name, age) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    @Update("UPDATE user SET age = #{age} WHERE name = #{name}")
    void update(User user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    void delete(Integer id);

    // 对于“查”操作，我们往往需要进行多表关联，汇总计算等操作，查询结果往往就不再是简单的实体对象了，
    // 往往需要返回一个与数据库实体不同的包装类，对于这类情况，就可以通过@Results和@Result注解来进行绑定
    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    @Select("SELECT name, age FROM user")
    List<User> findAll();
}
