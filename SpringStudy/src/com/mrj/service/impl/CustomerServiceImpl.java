package com.mrj.service.impl;

import com.mrj.service.ICustomerService;

import java.util.Date;

/**
 * 描述:
 * 业务层实现类
 *      构造方法注入
 *
 * @outhor MrJ
 * @create 2017-09-21 20:31
 */
public class CustomerServiceImpl  implements ICustomerService{

    private String name;
    private String address;
    private Date time;


    public CustomerServiceImpl(String name, String address, Date time) {
        this.name = name;
        this.address = address;
        this.time = time;
    }


    @Override
    public void saveCustomer() {
        System.out.println("名字 "+name+","+"地址 "+address+","+"时间 "+time);
    }
}
