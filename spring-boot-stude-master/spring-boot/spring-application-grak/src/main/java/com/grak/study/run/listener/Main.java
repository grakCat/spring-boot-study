package com.grak.study.run.listener;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created on 2019/5/18.
 *
 * @author hy
 * @since 1.0
 */
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(Main.class)
                .profiles("Dog")
                .run(args);
        DemoPublisher publisher = context.getBean("demoPublisher",DemoPublisher.class);
        publisher.publish(4,"任务1");
        publisher.publish(4,"任务2");
    }
}
