package com.grak.study;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.ClassUtils;

/**
 * Created on 2019/5/18.
 *
 * @author hy
 * @since 1.0
 */
@SpringBootApplication
public class SpringApplicationMain {

    public static void main(String[] args) {
        //1.
//        SpringApplication.run(SpringApplicationMain.class,args);

        //2.
//        SpringApplication springApplication = new SpringApplication(SpringApplicationMain.class);
//        springApplication.setWebApplicationType(WebApplicationType.REACTIVE);
//        springApplication.setAdditionalProfiles("Dog");
//        springApplication.setHeadless(true);

        //3.
        ConfigurableApplicationContext context = new SpringApplicationBuilder(SpringApplicationMain.class)
                .profiles("Dog")
                .web(WebApplicationType.NONE)
                .run(args);

        //判断指定类是否存在
        boolean have = ClassUtils.isPresent("com.grak.study.ready.init.Demo",null);
        System.out.println(have);
    }
}
