package com.demo.dao;

import com.demo.domain.Account;

/**
 * 描述:
 * 转账 DAO
 *
 * @outhor MrJ
 * @create 2017-09-23 12:48
 */
public interface IAccountDao {
    /**
     * 根据账户名称获取账户对象
     * @param sourceName
     * @return
     */
    Account findAccountByName(String sourceName);

    /**
     * 更新账户信息
     * @param sourceAccount
     */
    void updateAccount(Account sourceAccount);
}
