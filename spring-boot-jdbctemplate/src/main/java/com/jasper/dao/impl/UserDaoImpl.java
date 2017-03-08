package com.jasper.dao.impl;

import com.jasper.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by Jasper on 2017/2/27.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Integer id, String name, Integer age) {
        jdbcTemplate.update("insert into user(id, name, age) values(?, ?, ?)", id, name, age);
    }

    public void deleteByName(String name) {
        jdbcTemplate.update("delete from user where name = ?", name);
    }

    public Integer getAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from user", Integer.class);
    }

    public void deleteAllUsers() {
        jdbcTemplate.update("delete from user");
    }
}
