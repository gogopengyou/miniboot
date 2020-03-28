package com.yangzj.miniboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * description：The Project's boot application.
 *
 * @author yangzj
 * @date 2020/03/22
 */
@ServletComponentScan
//@EnableScheduling
//@MapperScan("com.yangzj.miniboot.domain.dao")
@SpringBootApplication
public class MinibootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MinibootApplication.class, args);
    }

}
