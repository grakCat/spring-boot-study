package com.grak.study.run.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created on 2019/5/20.
 *
 * @author hy
 * @since 1.0
 */
@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        //args 是启动类中的传入参数
        System.out.println("MyCommandLineRunner: 启动");
    }
}
