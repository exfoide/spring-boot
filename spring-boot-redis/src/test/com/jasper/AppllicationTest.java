package com.jasper;

import com.jasper.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Jasper on 2017/3/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Appllication.class)
public class AppllicationTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    @Test
    public void test(){
        //保存字符串
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void test1(){
        User user = new User("Super Man", 20);
        redisTemplate.opsForValue().set(user.getUsername(), user);

        user = new User("Spider Man", 30);
        redisTemplate.opsForValue().set(user.getUsername(), user);

        user = new User("Steal Man", 40);
        redisTemplate.opsForValue().set(user.getUsername(), user);

        Assert.assertEquals("20", redisTemplate.opsForValue().get("Super Man").getAge().toString());
        Assert.assertEquals("30", redisTemplate.opsForValue().get("Spider Man").getAge().toString());
        Assert.assertEquals("40", redisTemplate.opsForValue().get("Steal Man").getAge().toString());
    }
}