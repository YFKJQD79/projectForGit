package com.qdyinfukeji.pojo;

/**
 * 音符科技
 * 2021/5/26
 */
public class Orders {
    private int id;
    private String orderNumber;
    private double orderPrice;

    //多方会持有一方的对象
    private Customer customer;

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", orderPrice=" + orderPrice +
                ", customer=" + customer +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Orders(int id, String orderNumber, double orderPrice, Customer customer) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.orderPrice = orderPrice;
        this.customer = customer;
    }

    public Orders() {
    }
}
