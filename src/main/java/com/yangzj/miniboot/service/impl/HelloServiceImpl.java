package com.yangzj.miniboot.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yangzj.miniboot.Service.HelloService;
import org.springframework.stereotype.Component;

/**
 * description: 注意service引用的dubbo注解
 *
 * @author: Yangzj
 * @date: 2020/3/31
 */
@Component
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        System.out.println("sayHello方法被调用");
        return "Hello, " + name;
    }
}
