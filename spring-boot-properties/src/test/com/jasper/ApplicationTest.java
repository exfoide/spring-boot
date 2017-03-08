package com.jasper;


import com.jasper.service.BlogProperties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Jasper on 2017/3/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {
    private static final Log log = LogFactory.getLog(ApplicationTest.class);

    @Autowired
    private BlogProperties blogProperties;

    @Test
    public void test(){
        Assert.assertEquals("Jasper", blogProperties.getName());
        Assert.assertEquals("Spring Boot教程", blogProperties.getTitle());
        Assert.assertEquals("Jasper正在努力写《Spring Boot教程》", blogProperties.getDesc());

        log.info("随机数测试输出：");
        log.info("随机字符串 : " + blogProperties.getValue());
        log.info("随机int : " + blogProperties.getNumber());
        log.info("随机long : " + blogProperties.getBignumber());
        log.info("随机10以下 : " + blogProperties.getTest1());
        log.info("随机10-20 : " + blogProperties.getTest2());
    }
}