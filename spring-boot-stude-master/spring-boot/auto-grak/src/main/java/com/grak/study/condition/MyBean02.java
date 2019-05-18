package com.grak.study.condition;

import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created on 2019/5/18.
 *
 * @author hy
 * @since 1.0
 */
public class MyBean02 {

    @Bean
    public List<String> myList(){
        return Stream.iterate(2,x-> x * 4).limit(20).map(x -> x + "").collect(Collectors.toList());
    }

    @Bean
    public boolean MyBoolean(){
        return true;
    }
}
