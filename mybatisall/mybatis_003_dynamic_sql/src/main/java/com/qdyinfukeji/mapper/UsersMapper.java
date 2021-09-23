package com.qdyinfukeji.mapper;

import com.qdyinfukeji.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface UsersMapper {
    //查询用户所有信息
    List<Users> getAll();
    //按照主键id查询信息
    Users getById(int id);
    //增加用户
    int insert(Users users);
    //删除用户
    int delete( int id);

    //更新用户
    int update(Users users);

    //按用户名模糊查询用户类型
    List<Users>getByName(String username);

    //按用户名模糊查询用户类型
    List<Users>getByNameObject(Users userName);

    //替换列名查询
    List<Users>getByColumnName(
            @Param("columnName")
            String columnName,
            @Param("columnValue")
            String columnValue);
    //多条件查询
    List<Users>getMulCondition(Users users);

    //更新优化
    int updateGood(Users u);


    //查询指定的3,5,7id的用户信息
    List<Users> getByIds(int []ids);

    //按指定起始和终止日期进行查询/////////////////////  指定参数位置查询/////////////
    List<Users>getByBirthday(Date begin,Date end);


    //入参是map,进行起始和终止日期进行查询
    List<Users> getByMap(Map<String,Date> map);


    //批量增加用户
    int insertBatch(List<Users> list);




    //返回值是一行的map,根据id查用户名和用户的地址
    Map<String,String> getReturnMapOne(int id);

    //返回多行的map
    List<Map<String,String>> getReturnMapMul();

    //查询一个id段
    List<Users>getByIdd( int begin ,int end);

    //批量删除
    int deleteBatch(int []ids);

    //批量更新

    void updateBatch(List list);

}
