package com.qdyinfukeji.test;

import com.qdyinfukeji.mapper.UsersMapper;
import com.qdyinfukeji.pojo.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 音符科技
 * 2021/5/17
 */
public class Mytest {
    UsersMapper mapper;
    SqlSession sqlSession;
    //日期类型格式转换
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

    @Before //在所有@test执行之前，先执行@before里的代码
    public void openSqlSession() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = factory.openSession();
        //得到动态代理的对象
        mapper = sqlSession.getMapper(UsersMapper.class);
        System.out.println(mapper.getClass());
    }


    @Test
    public void testGetAll() throws Exception {

        //调用接口中的方法完成查询操作
        List<Users> list = mapper.getAll();
        //  List<Users> list = sqlSession.selectList("com.qdyinfukeji.mapper.UsersMapper.getAll");
        list.forEach(users -> System.out.println(users));

    }

    @Test
    public void testGetById() {
        Users u = mapper.getById(2);
        System.out.println(u);
    }

    @Test
    public void testInsert() throws Exception {
        Users u1 = new Users("柳传志", sf.parse("1965-08-15"), "男", "江苏南京");
        int num = mapper.insert(u1);

        //必须手动提交事务
        sqlSession.commit();
        System.out.println(num);
    }

    @Test
    public void testDelete() {
        int num = mapper.delete(27);
        sqlSession.commit();
        System.out.println(num);
        //Users u=new Users();

    }

    @Test
    public void testUpdate() throws Exception {

        Users u = new Users(40, "张蛋", sf.parse("1996-08-15"), "女", "克拉玛依");
        int num = mapper.update(u);
        sqlSession.commit();
        System.out.println(num);

    }

    @Test
    public void testGetByName() {
        List<Users> list = mapper.getByName("小");
        list.forEach(users -> System.out.println(users));

    }

    @Test
    public void testGetByNameObejct() {
        Users u = new Users();
        u.setUsername("小");
        List<Users> list = mapper.getByNameObject(u);
        list.forEach(users -> System.out.println(users));

    }

    @Test
    public void testGetByColumnName() {
        List<Users> list = mapper.getByColumnName("username", "张");
        list.forEach(users -> System.out.println(users));
    }

    @After
    public void closeSqlSession() {
        sqlSession.close();
    }
}
