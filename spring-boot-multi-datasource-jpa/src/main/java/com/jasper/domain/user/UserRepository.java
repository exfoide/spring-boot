package com.jasper.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Jasper on 2017/3/7.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
