package com.grak.study.enable_selector;

import com.grak.study.enable.HelloWorld;
import com.grak.study.enable.HelloWorld2;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created on 2019/5/18.
 *
 * @author hy
 * @since 1.0
 */
public class MySelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        String[] args = new String[]{HelloWorld.class.getName(), HelloWorld2.class.getName()};
        return args;
    }
}
