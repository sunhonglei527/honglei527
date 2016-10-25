package com.timeface.task;

import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

/**
 * Created by  on 2016/10/20.
 */
public class JobTest {

    public void testJob(){
        System.out.println("======Spring 定时任务========"+new Date().getTime());
    }
}
