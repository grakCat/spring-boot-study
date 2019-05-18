package com.grak.study.ready.init;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;

/**
 * Created on 2019/5/18.
 *
 * @author hy
 * @since 1.0
 */
public class ThirdApplicationInitialzer implements ApplicationContextInitializer<ConfigurableApplicationContext> , Ordered {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("ThirdApplicationInitialzer:start");
    }

    @Override
    public int getOrder() {
        return 3;
    }
}
