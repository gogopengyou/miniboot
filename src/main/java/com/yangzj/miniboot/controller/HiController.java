package com.yangzj.miniboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: just say hi~
 *
 * @author yangzj
 * @date 2020/03/22
 */
@RestController
@RequestMapping("hi")
public class HiController {

    @RequestMapping("say")
    public String sayHi() {
        // http://localhost/hi/say
        return "hello world.";
    }

}
