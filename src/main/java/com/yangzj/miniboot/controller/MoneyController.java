package com.yangzj.miniboot.controller;

import com.yangzj.miniboot.domain.entity.Money;
import com.yangzj.miniboot.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 *
 * @author yangzj
 * @date 2020/03/26
 */
@RestController
@RequestMapping("/money")
public class MoneyController {
    @Autowired
    private MoneyService moneyService;

    @RequestMapping("/query")
    public Money testQuery() {
        return moneyService.selectMoneyById(1);
    }
}
