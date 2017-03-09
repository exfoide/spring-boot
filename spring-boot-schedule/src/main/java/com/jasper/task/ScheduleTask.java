package com.jasper.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jasper on 2017/3/9.
 */
@Component
public class ScheduleTask {
    private final static DateFormat format = new SimpleDateFormat("HH时mm分ss秒");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime(){
        System.out.println("当前时间是:" + format.format(new Date()));
    }
}
