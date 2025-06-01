package com.bombo.completableFuture.configuration;

import java.util.concurrent.Executor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class AsyncExecutor {

    @Bean(name = "newAsyncExecutor")
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(12);
        executor.setMaxPoolSize(100);
        executor.setQueueCapacity(1000);
        executor.setKeepAliveSeconds(30);
        executor.setThreadNamePrefix("New Executor-");
        executor.initialize();

        return executor;
    }
}
