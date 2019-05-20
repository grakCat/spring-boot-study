package com.grak.study.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Created on 2019/5/20.
 *
 * @author hy
 * @since 1.0
 */
@EnableAsync
@SpringBootApplication(scanBasePackages = "com.grak.study")
public class AsyncApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AsyncApplication.class, args);
        AsyncTest test =(AsyncTest)context.getBean("asyncTest");
//        AsyncTest test = new AsyncTest();
//        test.test1();
//        test.test2();
        test.core1();
        test.core2();

        System.out.println("主线程执行完毕");
    }
}
