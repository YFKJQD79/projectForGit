package com.qdyinfukeji.mapper;


import com.qdyinfukeji.pojo.Orders;

public interface OrdersMapper {

    //按照订单编号查询订单信息，并同时查询下订单的客户信息

    Orders getById(int id);
}
