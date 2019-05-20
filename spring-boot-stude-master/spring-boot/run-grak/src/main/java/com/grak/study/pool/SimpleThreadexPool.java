package com.grak.study.pool;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.task.AsyncTaskExecutor;

/**
 * Created on 2019/5/20.
 *
 * @author hy
 * @since 1.0
 */

@Configuration
@PropertySource(value = {"classpath:executorAsync.properties"})
@ConfigurationProperties(prefix = "simple")
public class SimpleThreadexPool extends ParentThreadPool {

    private final String name = "simple_executor";

    @Bean(name)
    public AsyncTaskExecutor MessageExecutor() {
        return taskExecutor();
    }

    @Override
    protected int initCorePoolSize() {
        return 6;
    }

    @Override
    protected int initQueueCapacity() {
        return 80;
    }

    @Override
    protected int initKeepAliveSeconds() {
        return 20;
    }

    @Override
    protected String initThreadNamePrefix() {
        return "simple_async_executor";
    }
}
