package com.jasper;

import com.jasper.async.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.Future;

/**
 * Created by Jasper on 2017/3/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {
    @Autowired
    private Task task;

    @Test
    public void test() throws Exception{
        Long start = System.currentTimeMillis();

        Future<String> result1 = task.doTaskOne();
        Future<String> result2 = task.doTaskTwo();
        Future<String> result3 = task.doTaskThree();

        while(true) {
            if(result1.isDone() && result2.isDone() && result3.isDone()) {
                break;
            }
            Thread.sleep(1000);
        }

        Long end = System.currentTimeMillis();
        System.out.println("所有任务执行完成，总耗时:" + (end-start));
    }
}