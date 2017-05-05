package com.jasper;

import com.jasper.domain.User;
import com.jasper.domain.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by SysUser on 2017/5/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void before(){
        userRepository.save(new User("AAA", 15));
    }

    @Test
    public void test(){
        User user = userRepository.findByName("AAA");
        System.out.println("第一次查询：" + user.getAge());

        User user2 = userRepository.findByName("AAA");
        System.out.println("第二次查询：" + user2.getAge());

        user.setAge(20);
        userRepository.save(user);

        User user3 = userRepository.findByName("AAA");
        System.out.println("第三次查询：" + user3.getAge());
    }
}