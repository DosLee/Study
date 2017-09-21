package com.mr.service.impl;

import com.mr.service.ICustomerService;
import org.springframework.stereotype.Component;

/**
 * 描述:
 * 业务层实现类
 *
 * @outhor MrJ
 * @create 2017-09-21 22:21
 */
@Component("customerService")
public class CustomerServiceImpl implements ICustomerService {

    /**
     * @Component注解：
     * 		就相当于：
     * 		 <!-- 把资源（Service或者Dao）交给Spring来管理-->
     * 		 <bean class="com.mr.service.impl.CustomerServiceImpl" id="customerService"/>
     */

    @Override
    public void saveCustomer() {
        System.out.println("测试成功");
    }
}
