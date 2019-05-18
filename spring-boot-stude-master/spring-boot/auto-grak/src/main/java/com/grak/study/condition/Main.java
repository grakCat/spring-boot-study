package com.grak.study.condition;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

/**
 * Created on 2019/5/17.
 *
 * @author hy
 * @since 1.0
 */
@ConditionNote(name = "牛顿",age = 11)
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(Main.class)
                .web(WebApplicationType.NONE)
                .run(args);

        //有添加bean的名字，设置转换的类型
        List myList = context.getBean("myList", List.class);
        String name = context.getBean("name",String.class);
        System.out.println("name: " + name + ", myList: " + ArrayUtils.toString(myList));
        context.close();
    }
}
