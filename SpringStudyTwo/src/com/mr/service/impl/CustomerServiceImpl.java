package com.mr.service.impl;

import com.mr.dao.ICustomerDao;
import com.mr.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 描述:
 * 业务层实现类
 *
 * @outhor MrJ
 * @create 2017-09-21 22:21
 */
@Service("customerService")
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerDao customerDao;
    /**
     * @Component注解 和 @Service()注解
     * 		就相当于：
     * 		 <!-- 把资源（Service或者Dao）交给Spring来管理-->
     * 		 <bean class="com.mr.service.impl.CustomerServiceImpl" id="customerService"/>
     */

    @Override
    public void saveCustomer() {
        customerDao.saveCustomer();
    }
}
