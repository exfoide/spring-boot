package com.jasper;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Jasper on 2017/3/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTest {
    private Logger logger = Logger.getLogger(getClass());

    @Test
    public void test(){
        logger.info("输出info");
        logger.debug("输出debug");
        logger.error("输出error");
    }
}