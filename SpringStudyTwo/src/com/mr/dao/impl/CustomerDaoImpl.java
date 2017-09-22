package com.mr.dao.impl;

import com.mr.dao.ICustomerDao;
import org.springframework.stereotype.Repository;

/**
 * 描述:
 * 数据层实现类
 *
 * @outhor MrJ
 * @create 2017-09-21 22:20
 */
@Repository("CustomerDaoI")
public class CustomerDaoImpl implements ICustomerDao {

    @Override
    public void saveCustomer() {
        System.out.println("保存了客户");
    }
}
