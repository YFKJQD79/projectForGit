package com.qdyinfukeji.pojo;

import java.util.Date;

/**
 * 音符科技
 * 2021/5/17
 */
public class Users {
    private int id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;

    public int getId() {
        return id;
    }

    public Users setId(int id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Users setUsername(String username) {
        this.username = username;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Users setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public Users setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Users setAddress(String address) {
        this.address = address;
        return this;
    }

    public Users(String username, Date birthday, String sex, String address) {
        this.username = username;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
    }

    public Users() {
    }

    public Users(int id, String username, Date birthday, String sex, String address) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
