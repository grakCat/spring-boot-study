package com.grak.study.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created on 2019/5/16.
 *
 * @author Grak
 * @since 1.0
 */
@Data
@Configuration
public class Dog {

    @Value("dog.name")
    private String name;
    @Value("dog.age")
    private String age;

}
