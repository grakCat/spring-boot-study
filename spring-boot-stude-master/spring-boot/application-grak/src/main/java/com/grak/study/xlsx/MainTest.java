package com.grak.study.xlsx;

import com.grak.study.xlsx.sample.lsyguimajiang.LGMJConfiginfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created on 2019/5/18.
 *
 * @author hy
 * @since 1.0
 */
@SpringBootApplication
public class MainTest {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(MainTest.class, args);
        for(int i=0;i<99;i++){
            LGMJConfiginfo configinfo = LGMJConfiginfo.getLGMJConfiginfo(202);
            Thread.sleep(5000);
            System.out.println(configinfo.name);
        }
    }
}
