package com.qdyinfukeji.test;

import com.qdyinfukeji.mapper.BookMapper;
import com.qdyinfukeji.pojo.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.*;


/**
 * 音符科技
 * 2021/5/17
 */
public class Mytest {
    SqlSession sqlSession;
    BookMapper bookMapper;

    @Before //在所有@test执行之前，先执行@before里的代码
    public void openSqlSession() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = factory.openSession();
        //得到动态代理的对象
        bookMapper=sqlSession.getMapper(BookMapper.class);
        System.out.println(bookMapper.getClass());
    }

    @Test
    public void testGetBookAll(){
       List<Book>list=bookMapper.getAll();
        list.forEach(book -> System.out.println(book));

    }

    @Test
    public void testGetBookAllNew(){
        List<Book> list = bookMapper.getAllNew();
        list.forEach(book -> System.out.println(book));
    }
    @After
    public void closeSqlSession() {
        sqlSession.close();
    }
}
