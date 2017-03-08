package com.jasper.service;

/**
 * Created by Jasper on 2017/2/24.
 */
public interface UserService {
    /**
     * 新增一个用户
     * @param name
     * @param age
     */
    void create(Integer id, String name, Integer age);


    /**
     * 根据name删除一个用户高
     * @param name
     */
    void deleteByName(String name);

    /**
     * 获取用户总量
     */
    Integer getAllUsers();

    /**
     * 删除所有用户
     */
    void deleteAllUsers();
}
