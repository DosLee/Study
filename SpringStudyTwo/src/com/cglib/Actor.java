package com.cglib;

import com.proxy.IActor;

/**
 * 描述:
 * 基于子类的代理
 *
 * @outhor MrJ
 * @create 2017-09-22 23:03
 */
public class Actor{

    public void basicAct(float money){
        System.out.println("拿到钱开始基本的表演"+money);
    }

    public void dangerAct(float money){
        System.out.println("拿到钱开始危险的表演"+money);
    }
}
