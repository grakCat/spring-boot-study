package com.grak.study.run.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created on 2019/5/18.
 *
 * @author hy
 * @since 1.0
 */
@Component
public class DemoListener02 {

    @EventListener
    public void onApplicationEvent(DemoEvent demoEvent) {
        System.out.println(">>>>>>>>>DemoListener2>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("收到了：" + demoEvent.getSource() + "消息;时间：" + demoEvent.getTimestamp());
        System.out.println("消息：" + demoEvent.getId() + ":" + demoEvent.getMessage());
    }
}
