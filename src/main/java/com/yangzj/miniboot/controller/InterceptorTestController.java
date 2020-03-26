package com.yangzj.miniboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * description:
 *
 * @author yangzj
 * @date 2020/03/26
 */
@Controller
public class InterceptorTestController {

    @RequestMapping(value = { "/admin", "/admin/test" })
    public String test(Model model) {

        System.out.println("\n-------- MainController.test --- ");

        System.out.println(" ** You are in Controller ** ");

        return "test/test";
    }

    // This path is no longer used.
    // It will be redirected by OldLoginInterceptor
    @Deprecated
    @RequestMapping(value = { "/admin/oldLogin" })
    public String oldLogin(Model model) {

        // Code here never run.
        return "test/oldLogin";
    }

    @RequestMapping(value = { "/admin/login" })
    public String login(Model model) {

        System.out.println("\n-------- MainController.login --- ");

        System.out.println(" ** You are in Controller ** ");

        return "test/login";
    }

}