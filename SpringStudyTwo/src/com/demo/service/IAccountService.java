package com.demo.service;

/**
 * 描述:
 * 模拟转账
 *
 * @outhor MrJ
 * @create 2017-09-23 12:45
 */
public interface IAccountService {

    /**
     *
     * @param sourceAccountName 转出账户
     * @param targetAccountName 转入账户
     * @param money             转账金额
     */

    void transfer(String sourceAccountName,String targetAccountName,Float money);

    void test();
}
