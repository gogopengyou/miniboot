package com.yangzj.miniboot.controller;

import com.yangzj.miniboot.domain.entity.User;
import com.yangzj.miniboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * description:
 *
 * @author yangzj
 * @date 2020/03/26
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/query/xml")
    public User testQueryXML() {
        return userService.selectUserByNameByXML("test1");
    }

    @RequestMapping("/query")
    public User testQuery() {
        return userService.selectUserByName("test1");
    }

    @RequestMapping("/insert")
    public List<User> testInsert() {
        userService.insertService();
        return userService.selectAllUser();
    }


    @RequestMapping("/changemoney")
    public List<User> testchangemoney() {
        userService.changemoney();
        return userService.selectAllUser();
    }

    @RequestMapping("/delete")
    public String testDelete() {
        userService.deleteService(3);
        return "OK";
    }

}
