package com.qdyinfukeji.pojo;

/**
 * 音符科技
 * 2021/5/18
 */
public class Book {
    private int id;
    private String name;

    public Book(int id, String nane) {
        this.id = id;
        this.name = name;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public Book setId(int id) {
        this.id = id;
        return this;
    }

    public String getNane() {
        return name;
    }

    public Book setNane(String nane) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
