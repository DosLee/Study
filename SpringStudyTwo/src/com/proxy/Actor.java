package com.proxy;

/**
 * 描述:
 * 动态代理的接口实现类
 *
 * @outhor MrJ
 * @create 2017-09-22 22:01
 */
public class Actor implements  IActor {
    @Override
    public void basicActor(int money) {
        System.out.println("拿到钱开始表演");
    }

    @Override
    public void dangerActor(int money) {
        System.out.println("拿到钱开始危险类表演");
    }
}
