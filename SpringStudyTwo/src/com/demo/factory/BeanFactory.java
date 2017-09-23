package com.demo.factory;

import com.demo.service.IAccountService;
import com.demo.service.impl.AccountServiceImpl;
import com.demo.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 描述:
 * 动态代理
 *
 * @outhor MrJ
 * @create 2017-09-23 13:00
 */
public class BeanFactory {
    public static IAccountService getAccountService(){
        final IAccountService as = new AccountServiceImpl();
        IAccountService proxyInstance = (IAccountService) Proxy.newProxyInstance(as.getClass().getClassLoader(), as.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if ("transfer".equals(method.getName())) {
                    try {
                        TransactionManager.startTransaction();
                        method.invoke(as, args);
                        TransactionManager.commit();
                    } catch (Exception e) {
                        TransactionManager.rollback();
                        e.printStackTrace();
                    } finally {
                        TransactionManager.release();
                    }
                }
                return null;
            }
        });
        return proxyInstance;
    }
}
