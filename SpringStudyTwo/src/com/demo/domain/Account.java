package com.demo.domain;

import java.io.Serializable;

/**
 * 描述:
 * Bean类
 *
 * @outhor MrJ
 * @create 2017-09-23 12:50
 */
public class Account implements Serializable{
    private Integer id;
    private String name;
    private Float money;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Float getMoney() {
        return money;
    }
    public void setMoney(Float money) {
        this.money = money;
    }
}
