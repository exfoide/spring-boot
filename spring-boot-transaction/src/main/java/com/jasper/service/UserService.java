package com.jasper.service;

import com.jasper.domain.User;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Jasper on 2017/5/4.
 */
public interface UserService {
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    User login(String name, String password);
}
