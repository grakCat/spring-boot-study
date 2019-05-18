package com.grak.study.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * Created on 2019/5/18.
 *
 * @author hy
 * @since 1.0
 */
public class MyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Map<String, Object> attributes = annotatedTypeMetadata.getAnnotationAttributes(ConditionNote.class.getName());
        String propertyName = String.valueOf(attributes.get("name"));
        int propertyValue = (int)attributes.get("age");
        return propertyValue >= 10;
    }
}
