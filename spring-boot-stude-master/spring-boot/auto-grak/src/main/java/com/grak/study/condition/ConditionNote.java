package com.grak.study.condition;

import org.springframework.context.annotation.Conditional;
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
@Conditional(MyCondition.class)
@Import({MySelector02.class})
public @interface ConditionNote {

    String name();

    int age();
}
