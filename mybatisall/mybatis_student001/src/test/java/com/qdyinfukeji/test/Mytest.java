package com.qdyinfukeji.test;

import com.qdyinfukeji.mapper.StudentMapper;
import com.qdyinfukeji.pojo.Student;
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
 * 2021/5/17
 */
public class Mytest {
    SqlSession sqlSession;
    StudentMapper studentMapper;

    @Before
    public void openSqlSession()throws Exception{


        //1) 创建文件流，指向核心配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        //2)创建SqlSessionFactory的工厂对象
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);

        //3)获取SqlSession的对象
        //注意：设置为true则默认自动提交，不用再写sqlSession.commit();  默认是false
        sqlSession=factory.openSession(true);
        studentMapper = sqlSession.getMapper(StudentMapper.class);

    }
    @Test
    public void testGetAll() throws Exception{

        //4)完成查询操作并输出
        List<Student> list = sqlSession.selectList("com.qdyinfukeji.mapper.StudentMapper.getAll");
        list.forEach(student -> System.out.println(student));
        //关闭sqlSession对象
        //sqlSession.close();
    }
    @Test
    public void testGetById()throws Exception{
//
//        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
//
//
//        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//
//        SqlSession sqlSession = factory.openSession();

        Student student = sqlSession.selectOne("com.qdyinfukeji.mapper.StudentMapper.getById",3);
        System.out.println(student);

       // sqlSession.close();
    }
    @Test
    public void testInsert()throws Exception{

//        InputStream inputStream=Resources.getResourceAsStream("SqlMapConfig.xml");
//        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession=factory.openSession();
        Student stu=new Student("qiqi", "2159@qq.com", 29);
        int num = sqlSession.insert("com.qdyinfukeji.mapper.StudentMapper.insert", stu);
        //sqlSession.commit();
       // sqlSession.close();
        System.out.println(num);
    }
    @Test
    public void testDelete()throws Exception{
//        InputStream inputStream=Resources.getResourceAsStream("SqlMapConfig.xml");
//        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession=factory.openSession();
        int rows = sqlSession.delete("com.qdyinfukeji.mapper.StudentMapper.deleteById", 5);
//        sqlSession.commit();
//        sqlSession.close();
        System.out.println(rows);
    }
    @Test
    public void testUpdate()throws Exception{
      //  Student stu=new Student();
       // stu.setId(8);
     //   stu.setName("刘伟");//存在BUG，只更新了name，其余键值被清空
//        InputStream inputStream=Resources.getResourceAsStream("SqlMapConfig.xml");
//        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession=factory.openSession();
        Student stu=new Student(8, "好看", "5520@qq.com", 35);

      // int num =studentMapper.update(stu);
        int num = sqlSession.update("com.qdyinfukeji.mapper.StudentMapper.update",stu);
      //  sqlSession.commit();
       // sqlSession.close();
        System.out.println(num);


    }
    @After
    public void closeSqlSession(){
        sqlSession.close();
    }
}
