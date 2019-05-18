package com.grak.study.enable;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

/**
 * Created on 2019/5/17.
 *
 * @author hy
 * @since 1.0
 */
public class HelloWorld {

    /**
     * 这个没有添加Profile的bean会覆盖下面的两个，时其失去作用
     * @return
     */
//    @Bean("helloWorld")
//    public String helloWorld0(){
//        return "Hello World";
//    }

    @Profile("Dog")
    @Bean("helloWorld")
    public String helloWorld1(){
        return "Hello World Dog";
    }

    @Profile("Cat")
    @Bean("helloWorld")
    public String helloWorld2(){
        return "Hello World Cat";
    }
}
