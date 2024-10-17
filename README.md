# Management System
- `Author:` @luoxisteven
- `Tutor:` @qinge (@Copyright)

This is a frontend and backend project for a student management system from https://www.bilibili.com/video/BV1U44y1W77D/.

## Packages
1) Springboot
    - Website: https://spring.io/projects/spring-framework
2) Vue
    - Website: https://vuejs.org/guide/introduction.html
    - ElementUI
    - Axios
        - 安装 `npm i axios -s`
        - 查看是否安装好Axios: npm list axios
        - 配置 `request.js`
3) MySQL
4) MyBatis
5) MyBatis-Plus 
    - Website: https://mybatis.plus/
    - 更加简单实现增删改查，不用SQL
6) Lombok
    - 简化构造方法，构造函数

## Build
1) Vue
    - vue create \<filename>
2) SpringBoot
    - vscode: Install Extension `"Spring Initializr Java Support"`
    - 在搜索框输入 `>`
    - 在输入 `vscode-spring-initializr`
    - 点击 `Spring Initializr: Create a Maven Project`

## Run
1)  Frontend (Vue)：
    - 先 `cd 到vue文件夹内`
    - 再vue文件夹内运行：`npm run serve`
    - Website：http://localhost:8080/

2) Backend (Springboot)：
    - 在`SpringbootApplication.java`里run
    - Website：http://localhost:9090/

## User
Website: http://localhost:9090/user
```
Postman: 
    Get:
        localhost:9090/user/page?pageSize=20&pageNum=1&username=&email=&address=&nickname=
    Post: (Body: JSON) 删和改都用Post
    {
        "username": "abc",
        "password": "dasdf",
        "nickname":"asdfasdfasd"
    }
    Delete: 
        http://localhost:9090/user/{id}
```

## Resources (src/main/resources)
不同的配置文件:
1) application.yml
2) mapper/User.xml 配置xml之后，需要配置在application.yml


## Random Notes
- MyBatis

    一个对数据库进行增删改查的一个框架

- MyBatis-Plus

    Finish P8.zip 有用Plus之前的代码


## SpringBoot Notes
CSDN WEB: https://blog.csdn.net/cuiqwei/article/details/118188540

1) Controller 连接http访问和数据 (com.example.springboot.controller;)
2) Mapper 连接http和后台数据 (com.example.springboot.mapper;)
3) Service 可以连接Controller和Mapper (com.example.springboot.service;)

- Controller 负责处理请求和响应，连接 HTTP 请求与业务逻辑（Service）。
- Service 负责处理业务逻辑，连接 Controller 和数据访问层（Mapper）。
- Mapper 负责数据库操作，连接业务逻辑层（Service）和数据库。

