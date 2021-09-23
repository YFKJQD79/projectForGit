package com.qdyinfukeji.mapper;

import com.qdyinfukeji.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
    //批量删除
     int deleteBatch(int []ids);
}
