package com.yangzj.miniboot.service;

import com.yangzj.miniboot.domain.dao.db2.MoneyDao;
import com.yangzj.miniboot.domain.entity.Money;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * description:
 *
 * @author yangzj
 * @date 2020/03/26
 */
@Service
public class MoneyService {

    // @Resource是jdk注解（默认优先按name注入）
    @Resource
    private MoneyDao moneyDao;

    /**
     * 根据名字查找用户
     */
    public Money selectMoneyById(int id) {
        return moneyDao.findMoneyById(id);
    }

}