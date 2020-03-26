package com.yangzj.miniboot.service;

import com.yangzj.miniboot.domain.dao.db1.UserDao;
import com.yangzj.miniboot.domain.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:
 *
 * @author yangzj
 * @date 2020/03/26
 */
@Service
public class UserService {

    /**
     * @Resource 默认优先按名称注入（byName byType）
     */
    @Resource
    private UserDao userDao;

    /**
     * 根据名字查找用户(XML方式)
     */
    public User selectUserByNameByXML(String name) {
        return userDao.findUserByNameByXML(name);
    }

    /**
     * 根据名字查找用户
     */
    public User selectUserByName(String name) {
        return userDao.findUserByName(name);
    }

    /**
     * 查找所有用户
     */
    public List<User> selectAllUser() {
        return userDao.findAllUser();
    }

    /**
     * 插入两个用户
     */
    public void insertService() {
        userDao.insertUser("test1", 22, 3000.0);
        userDao.insertUser("test2", 19, 3000.0);
    }

    /**
     * 根据id 删除用户
     */

    public void deleteService(int id) {
        userDao.deleteUser(id);
    }

    /**
     * 模拟事务。由于加上了 @Transactional注解，如果转账中途出了意外 test1 和 test2 的钱都不会改变。
     */
    @Transactional
    public void changemoney() {
        userDao.updateUser("test1", 22, 2000.0, 3);
        // 模拟转账过程中可能遇到的意外状况
        int temp = 1 / 0;
        userDao.updateUser("tset2", 19, 4000.0, 4);
    }
}
