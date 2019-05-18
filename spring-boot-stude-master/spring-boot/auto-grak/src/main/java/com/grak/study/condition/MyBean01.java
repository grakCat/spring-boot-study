package com.grak.study.condition;

import org.springframework.context.annotation.Bean;

/**
 * Created on 2019/5/18.
 *
 * @author hy
 * @since 1.0
 */
public class MyBean01 {

    @Bean
    public int age(){
        return 55;
    }

    @Bean
    public String name(){
        return "黄大仙";
    }
}
