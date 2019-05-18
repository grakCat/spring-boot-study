package com.grak.study.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

/**
 * Created on 2019/5/16.
 *
 * @author Grak
 * @since 1.0
 */
@Data
@ConfigurationProperties(prefix = "novellist")
@Configuration
public class Cat {

    private List<String> color;

    private List<Map<String,String>> list;
}
