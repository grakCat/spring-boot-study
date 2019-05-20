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
@ConfigurationProperties(prefix = "core")
public class CoreThreadexPool  extends ParentThreadPool {

    private final String name = "core_executor";

    @Bean(name)
    public AsyncTaskExecutor MessageExecutor() {
        return taskExecutor();
    }

    @Override
    protected int initCorePoolSize() {
        return Runtime.getRuntime().availableProcessors() + 1;
    }

    @Override
    protected int initQueueCapacity() {
        return 1200;
    }

    @Override
    protected int initKeepAliveSeconds() {
        return 60;
    }

    @Override
    protected String initThreadNamePrefix() {
        return "core_async_executor";
    }
}
