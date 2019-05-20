package com.grak.study;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created on 2019/5/20.
 *
 * @author hy
 * @since 1.0
 */
@Controller
public class MyController {

    @RequestMapping("")
    public String index(@RequestParam int value, Model model) {
        return "index";
    }

}
