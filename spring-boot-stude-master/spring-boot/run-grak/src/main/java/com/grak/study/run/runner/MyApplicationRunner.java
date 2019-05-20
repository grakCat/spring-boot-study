package com.grak.study.run.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created on 2019/5/20.
 *
 * CommandLineRunner、ApplicationRunner 接口是在容器启动成功后的最后一步回调
 * 类似开机自启动
 *
 * CommandLineRunner的参数是最原始的参数，没有做任何处理。
 * ApplicationRunner的参数是ApplicationArguments，是对原始参数做了进一步的封装。
 *
 * @author hy
 * @since 1.0
 */
@Component
public class MyApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("MyApplicationRunner : 启动");
        //在启动类的Program arguments中添加传入参数   --foo=bar --tree.name=zhao.min
        System.out.println("===MyApplicationRunner==="+ Arrays.asList(args.getSourceArgs()));
        System.out.println("===getOptionNames========"+args.getOptionNames());
        System.out.println("===getOptionValues======="+args.getOptionValues("foo"));
        System.out.println("==getOptionValues========"+args.getOptionValues("tree.name"));
    }
}
