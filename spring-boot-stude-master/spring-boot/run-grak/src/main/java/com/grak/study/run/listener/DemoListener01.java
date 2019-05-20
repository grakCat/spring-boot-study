package com.grak.study.run.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created on 2019/5/18.
 *
 * 添加指定事件监听方法，
 * 1.实现ApplicationListener 接口
 * 2.使用@EventListener 注解
 * @author hy
 * @since 1.0
 */
@Component
public class DemoListener01 implements ApplicationListener<DemoEvent> {

    @Override
    public void onApplicationEvent(DemoEvent demoEvent) {
        System.out.println(">>>>>>>>>DemoListener>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("收到了：" + demoEvent.getSource() + "消息;时间：" + demoEvent.getTimestamp());
        System.out.println("消息：" + demoEvent.getId() + ":" + demoEvent.getMessage());
    }
}
