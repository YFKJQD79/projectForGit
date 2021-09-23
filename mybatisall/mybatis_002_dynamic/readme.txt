
搭建步骤:
 1).建库建表,users表
  2).在idea中刷新可视图
  3).新建Maven的javaSE的工程
  4).修改目录
  5).修改pom.xml文件,切记添加MyBatis和mysql驱动的依赖
  6).拷贝jdbc.properties属性,此文件中包括所有数据库连接信息
  7).添加MyBatis框架的核心配置文件,并开发
  8).添加实体类Users
  9).新建mapper包,添加UsersMapper.java的接口文件
  10).同一个目录下,添加UsersMapper.xml文件,完成增删改查的操作
  11).创建测试类,完成功能测试(优化)
