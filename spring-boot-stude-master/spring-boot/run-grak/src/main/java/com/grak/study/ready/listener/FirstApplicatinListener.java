package com.grak.study.ready.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Created on 2019/5/18.
 *
 * spring boot 添加监听器，监听上下文完成事件
 * ContextRefreshedEvent 需要监听的事件
 * 还可以通过添加bean的方式，在run里面
 * @author hy
 * @since 1.0
 */
public class FirstApplicatinListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("FirstApplicatinListener: " + event.getApplicationContext().getId()
                + ", timestamp : " + event.getTimestamp());
    }
}
