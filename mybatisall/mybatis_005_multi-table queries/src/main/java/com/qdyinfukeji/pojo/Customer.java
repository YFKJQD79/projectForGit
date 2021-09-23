package com.qdyinfukeji.pojo;

import java.util.List;

/**
 * 音符科技
 * 2021/5/26
 */
public class Customer {
    private int id;
    private String name;
    private int age;

    //为了同时查到该客户名下的所有订单信息，则创建成员变量订单的集合
    private List<Orders>oresrsList;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", oresrsList=" + oresrsList +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Orders> getOresrsList() {
        return oresrsList;
    }

    public void setOresrsList(List<Orders> oresrsList) {
        this.oresrsList = oresrsList;
    }

    public Customer(int id, String name, int age, List<Orders> oresrsList) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.oresrsList = oresrsList;
    }

    public Customer() {
    }
}
