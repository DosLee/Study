package com.demo.dao.impl;

import com.demo.dao.IAccountDao;
import com.demo.domain.Account;
import com.demo.utils.TransactionManager;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

/**
 * 描述:
 *
 * @outhor MrJ
 * @create 2017-09-23 12:49
 */
public class AccountDaoImpl implements IAccountDao {
    private QueryRunner qr = new QueryRunner();

    @Override
    public Account findAccountByName(String sourceName) {
        try{
            return qr.query(TransactionManager.getConnection(),"select * from account where name = ? ",new BeanHandler<Account>(Account.class),sourceName) ;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(Account sourceAccount) {
        try{
            qr.update(TransactionManager.getConnection(),"update account set name=?,money=? where id=? ",sourceAccount.getName(),sourceAccount.getMoney(),sourceAccount.getId()) ;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
