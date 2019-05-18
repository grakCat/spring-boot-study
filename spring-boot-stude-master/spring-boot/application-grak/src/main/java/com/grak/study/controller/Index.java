package com.grak.study.controller;

import com.grak.study.config.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2019/5/16.
 *
 * @author Grak
 * @since 1.0
 */
@RestController
public class Index {

    @Autowired
    Friends friends;
    @Autowired
    Dog dog;
    @Autowired
    Cat cat;
    @Autowired
    OtherPath otherPath;
    @Autowired
    Resources resources;

    @RequestMapping("/index")
    public String index(){
        return friends.toString();
    }

    @RequestMapping("/dog")
    public String dog(){
        return dog.toString();
    }

    @RequestMapping("/cat")
    public String cat(){
        System.out.println(cat.getColor().size());
        return cat.toString();
    }

    /**
     * ${user.dir} 获取到的是项目父类的绝对路径，里面需要添加子模块名才能使用
     * @return
     */
    @RequestMapping("/tree")
    public String tree(){
        return otherPath.toString();
    }

    @RequestMapping("/book")
    public String book(){
        return resources.toString();
    }

}
