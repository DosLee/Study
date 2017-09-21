package com.mr.ui;

import com.mr.service.impl.CustomerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 描述:
 * Main
 *
 * @outhor MrJ
 * @create 2017-09-21 22:25
 */
public class Client {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        CustomerServiceImpl cs = (CustomerServiceImpl) ac.getBean("customerService");
        cs.saveCustomer();
    }
}
