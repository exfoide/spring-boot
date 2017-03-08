package com.jasper.dao;

/**
 * Created by Jasper on 2017/2/27.
 */
public interface UserDao {
    public void create(Integer id, String name, Integer age);

    public void deleteByName(String name);

    public Integer getAllUsers();

    public void deleteAllUsers();
}
