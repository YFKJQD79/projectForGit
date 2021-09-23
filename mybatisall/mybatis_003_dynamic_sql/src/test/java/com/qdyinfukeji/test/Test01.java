package com.qdyinfukeji.test;

import com.qdyinfukeji.mapper.BookMapper;
import com.qdyinfukeji.mapper.UsersMapper;
import com.qdyinfukeji.pojo.Book;
import com.qdyinfukeji.pojo.Users;
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
    UsersMapper mapper;
    SqlSession sqlSession;
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

    @Before //在所有@test执行之前，先执行@before里的代码
    public void openSqlSession() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = factory.openSession();
        //得到动态代理的对象
        mapper = sqlSession.getMapper(UsersMapper.class);
     //   bookMapper=sqlSession.getMapper(BookMapper.class);
        System.out.println(mapper.getClass());
    }


    @Test
    public void testGetAll() throws Exception {
        //调用接口中的方法完成查询操作
        List<Users> list = mapper.getAll();
        list.forEach(users -> System.out.println(users));
    }

    @Test
    public void testGetById() {

        Users u = mapper.getById(2);
        System.out.println(u);
    }

    @Test
    public void testGetByIds() {
        int[] arrays = {3, 5, 7};
        List<Users> list = mapper.getByIds(arrays);
        list.forEach(users -> System.out.println(users));
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

    @Test
    public void testGetMulCondition() throws ParseException {

        Users u = new Users();
        u.setUsername("张");
        u.setBirthday(sf.parse("2002-05-13"));
        u.setAddress("上");
        List<Users> list = mapper.getMulCondition(u);
        list.forEach(users -> System.out.println(users));
    }

    @Test
    public void  testGetByIdd(){
        List<Users>list=mapper.getByIdd(2, 5);
        list.forEach(users -> System.out.println(users));

    }

        //指定参数位置多条件查询
    @Test
    public void testGetByBirthday() throws ParseException {

        List<Users> list = mapper.getByBirthday(sf.parse("2000-01-01"), sf.parse("2002-12-31"));
        list.forEach(users -> System.out.println(users));
    }


    //入参是map,进行起始和终止日期进行查询
    //List<Users> getByMap(Map<String,Date> map);

    @Test
    public void testGetByMap()throws Exception{

        //#{beginDate} and #{endDate}
        Map<String,Date> map = new HashMap<>();
        map.put("beginDate",sf.parse("1990-01-01") );
        map.put("endDate",sf.parse("2000-12-31") );
        List<Users> list = mapper.getByMap(map);
        list.forEach(users -> System.out.println(users));
    }

    //返回一行map
    @Test
    public void testGetReturnMapOne(){
        Map<String,String>map=mapper.getReturnMapOne(1);
        System.out.println(map);
        System.out.println(map.get("name"));
        System.out.println(map.get("addr"));

    }
    //返回多行的map
    // List<Map<String,String>> getReturnMapMul();
    @Test
    public void testgetReturnMapMul(){
        List<Map<String,String>>list=mapper.getReturnMapMul();
        System.out.println(list );


    }

    @Test
    public void testgetMulCondition()throws Exception{

        Users u=new Users();  //多条件查询
        u.setUsername("小");
        u.setBirthday(sf.parse("2002-11-19"));

        List<Users>list=mapper.getMulCondition(u);
        list.forEach(users -> System.out.println(users));
    }



    @Test
    public void testDelete() {
        int num = mapper.delete(44);
        sqlSession.commit();
        System.out.println(num);
        //Users u=new Users();
    }

    @Test
    public void  testdeleteBatch(){
            int []arrays={40,41,42,43};
        int num = mapper.deleteBatch(arrays);
        sqlSession.commit();
        System.out.println(num);


    }

    @Test  //*******************改*****************
    public void testUpdate() throws Exception {

        //Users u=new Users();
        //u.setId(3);
       // u.setUsername("刘备");
        Users u = new Users(3, "公孙策", sf.parse("1996-08-15"), "男", "克拉玛依");
        int num = mapper.update(u);
        sqlSession.commit();
        System.out.println(num);
    }

    @Test//更新优化****************改*********************
    public void testUpdateGood() {
        Users u = new Users();
        u.setId(3);
        u.setUsername("霸王");
        int num = mapper.updateGood(u);
        sqlSession.commit();
        System.out.println(num);
    }

    @Test
    public void testupdateBatch()throws Exception{

        List<Users>list=new ArrayList<>();
        Users u1=new Users(2, "关羽", sf.parse("1593-08-10"), "男", "蜀国");
        Users u2=new Users(3, "张郃", sf.parse("1583-08-10"), "男", "魏国");

        list.add(u1);
        list.add(u2);
         mapper.updateBatch(list);
        sqlSession.commit();

    }



    @Test
    public void testInsert() throws Exception {


        Users u1 = new Users("王兴", sf.parse("2000-08-15"), "女", "福田");
        int num = mapper.insert(u1);

        //////////////必须手动提交事务
        sqlSession.commit();
        System.out.println(num);
        System.out.println(u1);
    }


    @Test
    public void testInsertBatch() throws ParseException {
        //日期类型格式转换

       /* Users u1 = new Users("王兴", sf.parse("2000-08-15"), "女", "福田");
        int num = mapper.insert(u1);

        //////////////必须手动提交事务
        sqlSession.commit();
        System.out.println(num);*/
        Users u1 = new Users("小六子", sf.parse("1970-08-29"), "男", "沈阳");
        Users u2 = new Users("小海子", sf.parse("1960-04-15"), "男", "高丽");
        Users u3 = new Users("小州子", sf.parse("1860-05-28"), "男", "威海卫");
        Users u4 = new Users("小马子", sf.parse("1998-11-21"), "男", "天津卫");
        List<Users> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);
        int num = mapper.insertBatch(list);
        sqlSession.commit();
       System.out.println(num);

    }

    ///////要是不是全部的id怎么查？
    @Test
    public  void testResultMapMul(){
        List<Map<String,String>>list=mapper.getReturnMapMul();
        System.out.println(list);

    }


    //生成随机字符串
    @Test
    public void testUUID(){
        UUID uuid=UUID.randomUUID();
        System.out.println(uuid);
        System.out.println(uuid.toString().replace("-", "").substring(20));

    }


    @After
    public void closeSqlSession() {
        sqlSession.close();
    }
}
