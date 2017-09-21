package com.mrj.ui;

import com.mrj.service.ICustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 描述:
 * 客户端
 *
 * @outhor MrJ
 * @create 2017-09-21 20:31
 *
 *
 */
public class Client {
    public static void main(String[] args) {

        /*
		 * 1.获取到Spring的容器（map结构）
		 * ApplicationContext 就是spring的容器  里面存放的就是 key和value。
		 * 	key是一个字符串
		 * 	value是一个对象
		 * 获取对象的两种方式
		 * 	ClassPathXmlApplicationContext：它能加载类路径下的配置文件		***
		 *  FileSystemXmlApplicationContext：它能加载磁盘任意位置的配置文件
		 *
		 *  了解的内容：
		 *  	ApplicationContext和BeanFactory的共性和特性
		 *  	共性：
		 *  		都可以获取到spring的容器，并且由spring为我们创建Bean对象。
		 *  	区别：
		 *  		ApplicationContext在创建bean对象时，采用的是立即创建的策略（立即加载）	***
		 *  		BeanFactory在创建bean对象时，采用的是延迟创建的策略（延迟加载）
		 */

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ICustomerService cs = (ICustomerService) ac.getBean("customerService");
        cs.saveCustomer();
    }
}
