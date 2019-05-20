package com.grak.study.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created on 2019/5/20.
 *
 * @author hy
 * @since 1.0
 */
@Component
public class AsyncTest {

    @Async("simple_executor")
    public void test1() {
        System.out.println("异步执行test1！！！");
        System.out.println("线程id：" + Thread.currentThread().getId());
        System.out.println("线程名称：" + Thread.currentThread().getName());
    }

    @Async("simple_executor")
    public void test2() {
        System.out.println("异步执行test2！！！");
        System.out.println("线程id：" + Thread.currentThread().getId());
        System.out.println("线程名称：" + Thread.currentThread().getName());
    }

    @Async("core_executor")
    public void core1() {
        System.out.println("异步执行test2！！！");
        System.out.println("线程id：" + Thread.currentThread().getId());
        System.out.println("线程名称：" + Thread.currentThread().getName());
    }

    @Async("core_executor")
    public void core2() {
        System.out.println("异步执行test2！！！");
        System.out.println("线程id：" + Thread.currentThread().getId());
        System.out.println("线程名称：" + Thread.currentThread().getName());
    }
}
