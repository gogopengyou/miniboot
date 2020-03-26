package com.yangzj.miniboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * description：The Project's boot application.
 *
 * @author yangzj
 * @date 2020/03/22
 */
@ServletComponentScan
@SpringBootApplication
public class MinibootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MinibootApplication.class, args);
    }

}
