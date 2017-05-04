package com.jasper.mapper;

import com.jasper.domain.User;
import org.apache.ibatis.annotations.*;
/**
 * Created by Jasper on 2017/5/4.
 */
@Mapper
public interface UserMapper {

    @Select("select * from User where name = #{name}")
    User findByName(@Param("name") String name);

    @Insert("insert into user(name, age) values(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);
}
