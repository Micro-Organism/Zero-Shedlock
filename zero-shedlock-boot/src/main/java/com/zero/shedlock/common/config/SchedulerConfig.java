package com.zero.shedlock.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class SchedulerConfig {

    //TODO: add shedlock config
    //TODO: add scheduler config

    //TODO: add job config
    //TODO: add job listener config
    //TODO: add job listener factory config
    //TODO: add job listener registry config

    @Bean
    public JdbcTemplate jdbcTemplate() {
        //初始化 JdbcTemplate
        return new JdbcTemplate();
    }

}
