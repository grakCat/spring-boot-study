package com.grak.study.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

/**
 * Created on 2019/5/18.
 *
 * @author hy
 * @since 1.0
 */
@Data
@Configuration
@PropertySource(value = "classpath:book.properties")
@ConfigurationProperties(prefix = "book")
public class Resources {
    private String whit;

    private int age;

    private boolean boos;

    private String color;

    private List<String> list;

    @Value("classpath:")
    private String topPath;
}
