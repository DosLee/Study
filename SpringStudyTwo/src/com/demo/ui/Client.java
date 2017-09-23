package com.demo.ui;

import com.demo.factory.BeanFactory;
import com.demo.service.IAccountService;

/**
 * 描述:
 * 测试类
 *
 * @outhor MrJ
 * @create 2017-09-23 12:52
 */
public class Client {
    public static void main(String[] args) {
        IAccountService accountService = BeanFactory.getAccountService();//代理对象
        accountService.transfer("aaa","bbb", 100f);
    }
}
