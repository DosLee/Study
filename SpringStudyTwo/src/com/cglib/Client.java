package com.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 描述:
 * 基于子类的代理
 *
 * @outhor MrJ
 * @create 2017-09-22 23:07
 */
public class Client {
    public static void main(String[] args) {
        final Actor actor = new Actor();
		/*
		 * 创建代理对象
		 * 	  使用 Enhancer.create(Class, CallBack)方法。
		 * 参数含义：
		 * 	  Class：被代理对象的字节码
		 * 	  Callback：如何代理。
		 */
        Actor cglibActor = (Actor) Enhancer.create(actor.getClass(), new MethodInterceptor() {
            /**
             * 执行被代理对象的任何方法，都会经过该方法
             */
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                Float money = (Float) args[0];
                if("basicAct".equals(method.getName())){
                    if(money > 10000){
                        method.invoke(actor, money/2);
                    }
                }
                if("dangerAct".equals(method.getName())){
                    if(money > 50000){
                        method.invoke(actor, money/2);
                    }
                }
                return null;
            }
        });

        cglibActor.basicAct(20000);
        cglibActor.dangerAct(100000);
    }
}
