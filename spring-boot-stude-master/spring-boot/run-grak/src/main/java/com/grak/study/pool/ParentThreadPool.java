package com.grak.study.pool;

import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created on 2019/5/20.
 *
 * @author hy
 * @since 1.0
 */
public abstract class ParentThreadPool {

    /**
     * 核心线程数：线程池创建时候初始化的线程数
     */
    private int corePoolSize;

    /**
     * 最大线程数：线程池最大的线程数，只有在缓冲队列满了之后才会申请超过核心线程数的线程
     */
    private int maxPoolSize;
    /**
     * 缓冲队列200：用来缓冲执行任务的队列
     */
    private int queueCapacity;

    /**
     * 允许线程的空闲时间(单位：秒)：当超过了核心线程出之外的线程在空闲时间到达之后会被销毁
     */
    private int keepAliveSeconds;

    /**
     * 线程池名的前缀：设置好了之后可以方便我们定位处理任务所在的线程池
     */
    private String threadNamePrefix;

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public void setQueueCapacity(int queueCapacity) {
        this.queueCapacity = queueCapacity;
    }

    public void setKeepAliveSeconds(int keepAliveSeconds) {
        this.keepAliveSeconds = keepAliveSeconds;
    }

    public void setThreadNamePrefix(String threadNamePrefix) {
        this.threadNamePrefix = threadNamePrefix;
    }

    protected AsyncTaskExecutor taskExecutor(){
        init();
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(keepAliveSeconds);
        executor.setThreadNamePrefix(threadNamePrefix);

        // 线程池对拒绝任务的处理策略：这里采用了CallerRunsPolicy策略，当线程池没有处理能力的时候，该策略会直接在 execute 方法的调用线程中运行被拒绝的任务；如果执行程序已关闭，则会丢弃该任务
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }

    protected abstract AsyncTaskExecutor MessageExecutor();

    protected abstract int initCorePoolSize();

    protected abstract int initQueueCapacity();

    protected abstract int initKeepAliveSeconds();

    protected abstract String initThreadNamePrefix();

    /**
     * 设置线程池默认值
     */
    private void init(){
        if(corePoolSize <= 0){
            corePoolSize = initCorePoolSize();
        }
        if(maxPoolSize <= 0){
            maxPoolSize = (Runtime.getRuntime().availableProcessors()) * 2;
            if(corePoolSize > maxPoolSize){
                corePoolSize = maxPoolSize;
            }
        }
        if(queueCapacity <= 0){
            queueCapacity = initQueueCapacity();
        }
        if(keepAliveSeconds <= 0){
            keepAliveSeconds = initKeepAliveSeconds();
        }
        if(threadNamePrefix == null){
            threadNamePrefix = initThreadNamePrefix();
        }
    }
}
