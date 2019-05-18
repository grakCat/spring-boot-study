package com.grak.study.enable_selector;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created on 2019/5/17.
 *
 * @author hy
 * @since 1.0
 */
@MyEnableSelector
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(Main.class)
                .web(WebApplicationType.NONE)
                .profiles("Dog")
                .run(args);

        //有添加bean的名字，设置转换的类型
        String demo = context.getBean("helloWorld",String.class);
        int age = context.getBean("age",int.class);
        System.out.println("demo: " + demo + ", age: " + age);
        context.close();
    }
}
