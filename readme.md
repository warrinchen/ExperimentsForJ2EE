# 介绍
本项目是JavaEE轻量级架构的三个实验的总和

# 访问方法
1. 实验一: localhost/exp1
2. 实验二: localhost/exp2
3. 实验三: localhost/exp3

# 代码

## 实验一

控制器类: src/main/java/com/exp/controller/TableController.java

服务接口: src/main/java/com/exp/service/TableItemService.java

实体类: src/main/java/com/exp/entity/TableItem.java

前端页面: src/main/webapp/WEB-INF/ftl/exp1.ftl

## 实验二

控制器类: src/main/java/com/exp/controller/TreeController.java

服务实现类: src/main/java/com/exp/service/impl/TreeItemServiceImpl.java 

服务接口: src/main/java/com/exp/service/TreeItemService.java

实体类: src/main/java/com/exp/entity/TreeItem.java

mapper接口: src/main/java/com/exp/mapper/TreeItemMapper.java

mapper文件: src/main/resources/mappers/TreeItemMapper.xml

前端页面: src/main/webapp/WEB-INF/ftl/exp2.ftl

## 实验三

控制器类:src/main/java/com/exp/controller/BookController.java

服务实现类:src/main/java/com/exp/service/impl/BookServiceImpl.java
src/main/java/com/exp/service/impl/UserServiceImpl.java

服务接口: src/main/java/com/exp/service/BookService.java
src/main/java/com/exp/service/UserService.java

实体类:src/main/java/com/exp/entity/Book.java
src/main/java/com/exp/entity/User.java

mapper接口: src/main/java/com/exp/mapper/BookMapper.java
src/main/java/com/exp/mapper/UserMapper.java

mapper文件:src/main/resources/mappers/BookMapper.xml
src/main/resources/mappers/UserMapper.xml

前端页面: src/main/webapp/WEB-INF/ftl/exp3.ftl
src/main/webapp/WEB-INF/ftl/exp3-content.ftl
src/main/webapp/WEB-INF/ftl/book-add.ftl
src/main/webapp/WEB-INF/ftl/book-detail.ftl
