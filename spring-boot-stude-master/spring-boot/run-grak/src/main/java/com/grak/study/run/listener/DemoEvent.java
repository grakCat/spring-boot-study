package com.grak.study.run.listener;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * Created on 2019/5/18.
 *
 * 自定义事件信息
 * @author hy
 * @since 1.0
 */
@Data
public class DemoEvent extends ApplicationEvent {
    private Long id;
    private String message;

    public DemoEvent(Object source, Long id, String message) {
        super(source);
        this.id = id;
        this.message = message;
    }
}
