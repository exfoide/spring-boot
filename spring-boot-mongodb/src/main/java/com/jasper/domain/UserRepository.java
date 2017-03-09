package com.jasper.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Jasper on 2017/3/9.
 */
public interface UserRepository extends MongoRepository<User, Long> {
    User findByName(String name);
}
