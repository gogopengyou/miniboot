package com.yangzj.miniboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * description:
 *
 * @author yangzj
 * @date 2020/03/23
 */
@Controller
@RequestMapping("leaf")
public class LeafController {

    @RequestMapping("greeting")
    public String greeting(@RequestParam(name="name", required = false, defaultValue = "wtf") String name, Model model) {
        model.addAttribute("name", name);
        return "leaf/greeting";
    }


}
