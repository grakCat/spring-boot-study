package com.grak.study.ready.init;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;

/**
 * Created on 2019/5/18.
 *
 * 启动类初始化器
 * 准备阶段调用（最开始）
 * @author hy
 * @since 1.0
 */
//指定执行顺序，只能指定同一阶段内的顺序，比如都是初始化器
//数字越小，优先级越高
//也可以 实现Ordered接口，在ThirdApplicationInitialzer有实现
@Order(1)
public class FirstApplicationInitialzer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("FirstApplicationInitialzer:start");
    }
}
