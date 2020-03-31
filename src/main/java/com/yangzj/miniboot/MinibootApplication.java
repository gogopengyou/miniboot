package com.yangzj.miniboot;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * description：The Project's boot application.
 * ServletComponentScan 用于开启过滤器扫描
 * EnableScheduling 用于开启springboot定时任务模块
 * MapperScan 用于扫描Mybatis映射文件（实际可以不加，只需加Mapper注解）
 * EnableDubboConfiguration 启用dubbo自动化配置
 * SpringBootApplication：@Configuration、@EnableAutoConfiguration、@ComponentScan
 *
 * @author yangzj
 * @date 2020/03/22
 */
@ServletComponentScan
//@EnableScheduling
//@MapperScan("com.yangzj.miniboot.domain.dao")
@EnableDubboConfiguration
@SpringBootApplication
public class MinibootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MinibootApplication.class, args);
    }

}
