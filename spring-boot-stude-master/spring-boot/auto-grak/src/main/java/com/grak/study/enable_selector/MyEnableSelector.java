package com.grak.study.enable_selector;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Created on 2019/5/18.
 *
 * @author hy
 * @since 1.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({MySelector.class})
public @interface MyEnableSelector {
}
