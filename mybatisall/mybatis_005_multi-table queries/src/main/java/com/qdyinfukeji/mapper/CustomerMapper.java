package com.qdyinfukeji.mapper;

import com.qdyinfukeji.pojo.Customer;

public interface CustomerMapper {

    //按主键查客户信息，并同时查到此客户名下的所有订单

    Customer getById(int id);
}
