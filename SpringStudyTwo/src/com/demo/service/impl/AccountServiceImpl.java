package com.demo.service.impl;

import com.demo.dao.IAccountDao;
import com.demo.dao.impl.AccountDaoImpl;
import com.demo.domain.Account;
import com.demo.service.IAccountService;

/**
 * 描述:
 * 转账
 *
 * @outhor MrJ
 * @create 2017-09-23 12:48
 */
public class AccountServiceImpl implements IAccountService{

    //创建持久层对象
    private IAccountDao dao = new AccountDaoImpl();

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        Account sourceAccount = dao.findAccountByName(sourceName);//转出账户
        Account targetAccount = dao.findAccountByName(targetName);//转入账户
        sourceAccount.setMoney(sourceAccount.getMoney()-money);//设置转出账户剩余金额
        targetAccount.setMoney(targetAccount.getMoney()+money);//设置转入账户剩余金额
        dao.updateAccount(sourceAccount);//更新转出账户
        //模拟转账异常
        int i=1/0;
        dao.updateAccount(targetAccount);//更新转入账户
    }

    @Override
    public void test() {
        System.out.println("你好");
    }
}
