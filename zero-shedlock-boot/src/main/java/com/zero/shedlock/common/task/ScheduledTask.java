package com.zero.shedlock.common.task;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 每分钟执行一次
    @Scheduled(cron = "0 0/1 * * * ?")
    @SchedulerLock(name = "scheduledTask", lockAtLeastFor = "5s", lockAtMostFor = "10s")
    public void executeTask() {
        System.out.println("执行定时任务：" + System.currentTimeMillis());
        // 模拟任务处理
        try {
            // 模拟任务耗时
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // 每天凌晨 2 点清理
    @Scheduled(cron = "0 0 2 * * ?")
    public void cleanExpiredLocks() {
        String sql = "DELETE FROM shedlock WHERE lock_until < NOW()";
        jdbcTemplate.execute(sql);
    }

}
