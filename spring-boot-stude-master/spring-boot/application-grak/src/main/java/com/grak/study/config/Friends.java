package com.grak.study.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * Created on 2019/5/16.
 *
 * @author Grak
 * @since 1.0
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "friends")
public class Friends {

    private String lastName;

    private int age;

    private String danyin;

    private String shuang;

    private boolean boos;

    private Date birth;
}
