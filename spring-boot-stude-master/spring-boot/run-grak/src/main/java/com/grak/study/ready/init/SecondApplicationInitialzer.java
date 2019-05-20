package com.grak.study.ready.init;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;

/**
 * Created on 2019/5/18.
 *
 * @author hy
 * @since 1.0
 */
@Order(2)
public class SecondApplicationInitialzer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("SecondApplicationInitialzer:start");
    }
}
