package com.yuge.ing.business.server.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author: yuge
 * @date: 2021-05-19
 **/
@Slf4j
@Component
public class ScheduledJob {

    private static ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

//    @PostConstruct
    public void doSomething() {
        executor.schedule(new Task(), 10, TimeUnit.SECONDS);
    }

    public static class Task implements Runnable {

        @Override
        public void run() {
            log.info("schedule do something.");
            executor.schedule(this, 10, TimeUnit.SECONDS);
        }
    }

}
