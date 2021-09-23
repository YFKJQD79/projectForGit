package com.qdyinfukeji.mapper;

import com.qdyinfukeji.pojo.Student;

import java.util.List;

public interface StudentMapper {

    //查询学生信息
    List<Student>  getAll();


    //按主键值查一个学生数据
    Student getById(int id);


   //  完成增加学生的操作
   int insert(Student stu);

   //删除一个学生信息
   int deleteById(int id);


    //更新学生
    int update(Student student);
}
