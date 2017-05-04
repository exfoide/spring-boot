package com.jasper;

import com.jasper.domain.User;
import com.jasper.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Jasper on 2017/5/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {
    @Autowired
    private UserMapper userMapper;


    @Test
    public void test(){
        userMapper.insert("AAA", 10);

        User user = userMapper.findByName("AAA");
        Assert.assertEquals(10, user.getAge().intValue());
    }
}