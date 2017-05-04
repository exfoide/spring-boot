package com.jasper.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Jasper on 2017/5/4.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName(String name);

    User findByNameAndAge(String name, Integer age);

    @Query("from User user where user.name = :name")
    User findUser(@Param("name") String name);
}
