package com.grak.study.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created on 2019/5/18.
 *
 * @author hy
 * @since 1.0
 */
public class MySelector02 implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        String[] args = new String[]{MyBean01.class.getName(), MyBean02.class.getName()};
        return args;
    }
}
