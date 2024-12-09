package com.zero.shedlock.common.component;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    @Scheduled(cron = "0 */1 * * * ?") // 每分钟运行一次
    @SchedulerLock(name = "myTask", lockAtMostFor = "PT10M", lockAtLeastFor = "PT1M")
    public void executeTask() {
        System.out.println("Executing scheduled task...");
    }
}
