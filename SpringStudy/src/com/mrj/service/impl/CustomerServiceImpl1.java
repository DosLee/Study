package com.mrj.service.impl;

import com.mrj.service.ICustomerService;

import java.util.Date;

/**
 * 描述:
 *  使用set方法注入
 *
 * @outhor MrJ
 * @create 2017-09-21 21:44
 */
public class CustomerServiceImpl1 implements ICustomerService{
    private String name;
    private Integer age;
    private Date birthday;



    public void setName(String name) {
        this.name = name;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public void saveCustomer() {
        System.out.println(name+","+age+","+birthday);
    }
}
