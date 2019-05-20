package com.grak.study.run.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created on 2019/5/18.
 * 消息发布者
 * @author hy
 * @since 1.0
 */
@Component
public class DemoPublisher {

    /**
     * 就是在spring boot的上下文中，发布监听事件。之后在逻辑中调用（观察者设计模式）
     */
    private final ApplicationContext applicationContext;

    @Autowired
    public DemoPublisher(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void publish(long id, String message) {
        applicationContext.publishEvent(new DemoEvent(this, id, message));
    }

}
