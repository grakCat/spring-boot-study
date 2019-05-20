package com.grak.study.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * Created on 2019/5/18.
 *
 * 添加运行时监听器，是对spring boot整体启动各部分的监听
 * starting和environmentPrepared 执行顺序孩子初始化器之前
 * @author hy
 * @since 1.0
 */
@Order(0)
public class MyRunListener implements SpringApplicationRunListener {

    public MyRunListener(SpringApplication application, String[] args) {

    }

    @Override
    public void starting() {
        System.out.println("Spring 应用刚启动");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        System.out.println("ConfigurableEnvironment 准备妥当，允许将其调整 ");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("ConfigurableApplicationContext 准备妥当，允许将其调整");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("ConfigurableApplicationContext 已装载，但仍未启动 ");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("ConfigurableApplicationContext 已启动，此时 Spring Bean 已初始化完成");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("Spring 应用正在运行");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("Spring 应用运行失败 ");
    }
}
