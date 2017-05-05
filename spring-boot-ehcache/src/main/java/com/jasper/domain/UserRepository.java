package com.jasper.domain;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by SysUser on 2017/5/5.
 */
@CacheConfig(cacheNames = "users")
public interface UserRepository extends JpaRepository<User, Integer> {
    @Cacheable(key = "#p0", condition = "#p0.length() < 10")
    User findByName(String name);
}
