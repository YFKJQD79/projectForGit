package com.qdyinfukeji.test;

import com.qdyinfukeji.mapper.CustomerMapper;
import com.qdyinfukeji.mapper.OrdersMapper;
import com.qdyinfukeji.pojo.Customer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 音符科技
 * 2021/5/17
 */
public class Test01 {
   // UsersMapper mapper;
    SqlSession sqlSession;
  //  BookMapper bookMapper;
    CustomerMapper customerMapper;
    //OrdersMapper ordersMapper;

    @Before //在所有@test执行之前，先执行@before里的代码
    public void openSqlSession() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = factory.openSession();
        //得到动态代理的对象
       // mapper = sqlSession.getMapper(UsersMapper.class);
       // bookMapper=sqlSession.getMapper(BookMapper.class);
        customerMapper=sqlSession.getMapper(CustomerMapper.class);
       // ordersMapper=sqlSession.getMapper(OrdersMapper.class);
        //System.out.println(mapper.getClass());
        System.out.println(customerMapper.getClass());
       // System.out.println(ordersMapper.getClass());
    }


    @Test
    public void testGetById(){
        Customer customer=customerMapper.getById(3);
        System.out.println(customer);

    }

    @After
    public void closeSqlSession() {
        sqlSession.close();
    }
}
