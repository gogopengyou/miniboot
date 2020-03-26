package com.yangzj.miniboot.controller;

import com.google.common.collect.ImmutableMap;
import com.yangzj.miniboot.domain.entity.Book;
import com.yangzj.miniboot.utils.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:全局异常控制测试
 *
 * @author yangzj
 * @date 2020/03/25
 */
@RestController
@RequestMapping("exception")
public class ExceptionTestController {

    @GetMapping("test")
    public void test() {
        Book b1 = new Book();
        Book b2 = new Book();
        b1.setName("test1");
        b2.setName("test2");
        b1.setDescription("111");
        b2.setDescription("222");
        // {"code":1001,"status":404,"message":"未找到该资源","path":"/exception/test",
        // "timestamp":"2020-03-24T23:31:16.991Z","data":{"name":"test1","description":"111"}}
        throw new ResourceNotFoundException(ImmutableMap.of("name", b1.getName(), "description", b1.getDescription()));

        //{"code":1000,"status":500,"message":"服务器内部发生异常","path":"/exception/test",
        // "timestamp":"2020-03-25T00:25:23.192Z","data":{"java.lang.ArithmeticException: / by zero":"/ by zero"}}
        //int a = 1/0;

        /*String c = "1";
        c.substring(5);*/
    }

    @GetMapping("test2")
    public void test2() {
        int a = 1/0;
    }

}
