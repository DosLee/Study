package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 描述:
 * 动态代理
 *
 * @outhor MrJ
 * @create 2017-09-22 22:03
 */
public class Client {
    public static void main(String[] args) {

        //Actor actor = new Actor();
        //actor.basicActor(1000);
        //actor.dangerActor(2000);

        /**
         * 动态代理：
         * 	使用的是Proxy类
         *  用newProxyInstance方法
         *  该方法有3个参数：
         *  	ClassLoader：和被代理对象使用相同的类加载器
         *  	Class[]：实现的接口。和被代理对象需要有相同的方法。（具备相同的行为）
         *  	InvocationHandler：是如何代理。需要写一个匿名内部类。里面的代码由我们自己来实现
         *  					      使用的策略模式。
         *  					  什么情况下适用策略模式：
         *  							数据已经有了，目标明确。
         *  					达成目标的过程就是策略。谁用谁写。
         */

        final Actor actor = new Actor();
        IActor proxyInstance = (IActor) Proxy.newProxyInstance(actor.getClass().getClassLoader(), actor.getClass().getInterfaces(), new InvocationHandler() {

            /**
             * invoke方法特点：
             * 		执行被代理对象的任何方法都会经过该方法，此方法有拦截的功能。
             * 		增强的代码都行写在此方法内部。
             * 方法的参数
             * 		Object proxy：代理对象的引用，不一定用得到。
             * Method method：当前执行的方法对象。
             * Object[] args：当前执行方法所需要的参数
             * Object返回值：
             *      当前执行方法的返回值
             */

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                int money = (int) args[0];
                if ("basicActor".equals(method.getName())) {
                    if (money > 10000) {
                        System.out.println("开始普通表演");
                    }
                }
                if ("dangerActor".equals(method.getName())) {
                    if (money > 50000) {
                        System.out.println("开始危险表演");
                    }
                }
                return null;
            }
        });

        //proxyInstance.basicActor(2000);
        //proxyInstance.dangerActor(5000);

        proxyInstance.basicActor(20000);
        proxyInstance.dangerActor(60000);
    }
}
