package com.yangzj.miniboot.controller;

import com.google.common.collect.ImmutableMap;
import com.yangzj.miniboot.domain.entity.Book;
import com.yangzj.miniboot.utils.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
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

        throw new ResourceNotFoundException(ImmutableMap.of("name", b1.getName(), "description", b1.getDescription()));
    }

}
