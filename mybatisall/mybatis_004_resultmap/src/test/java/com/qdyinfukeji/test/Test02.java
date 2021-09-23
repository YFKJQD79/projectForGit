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
import java.util.List;

/**
 * 音符科技
 * 2021/5/25
 */
public class Test02 {
    SqlSession sqlSession;//在步骤3中提取出的SqlSession对象
    BookMapper bookMapper;//得到的动态代理的对象

    @Before //在所有@test执行之前，先执行@before里的代码
    public void openSqlSession() throws Exception {
        //1)创建文件流，指向核心配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2)创建sqlsessionfactory工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //3)获取sqlsession的对象
        sqlSession = factory.openSession();
        //得到动态代理的对象
        //mapper= sqlSession.getMapper(UsersMapper.class);
        bookMapper=sqlSession.getMapper(BookMapper.class);
        System.out.println(bookMapper.getClass());
    }
    @Test
    public void testGetBookAll(){
        List<Book> list=bookMapper.getAll();
        list.forEach(book -> System.out.println(book));
    }

    @Test
    public void testGetAllNew(){
        List<Book> list=bookMapper.getAllNew();
        list.forEach(book -> System.out.println(book));
    }

    @After
    public void closeSqlSession() {
        sqlSession.close();
    }
}
