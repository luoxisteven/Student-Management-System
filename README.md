# Management System
- @Author: @luoxisteven
- @Teacher: @qinge (@Copyright Reserve)

This is a frontend and backend project for a student management system from https://www.bilibili.com/video/BV1U44y1W77D/.

## SpringBoot Notes
CSDN WEB: https://blog.csdn.net/cuiqwei/article/details/118188540

1) Controller 连接http访问和数据 (com.example.springboot.controller;)
2) Mapper 连接http和后台数据 (com.example.springboot.mapper;)
3) Service 可以连接Controller和Mapper (com.example.springboot.service;)

- Controller 负责处理请求和响应，连接 HTTP 请求与业务逻辑（Service）。
- Service 负责处理业务逻辑，连接 Controller 和数据访问层（Mapper）。
- Mapper 负责数据库操作，连接业务逻辑层（Service）和数据库。

### Resources (src/main/resources)
不同的配置文件:
1) application.yml
2) mapper/User.xml 配置xml之后，需要配置在application.yml


## Vue Notes



## Run
1)  Frontend：
    - 先 `cd springboot cd vue`

    - 再vue文件夹内运行：`npm run serve`

        Website：http://localhost:8080/

2) Backend：
在SpringbootApplication.java里 run 程序
    
    Website：http://localhost:9090/

## User
Website: http://localhost:9090/user
```
Postman: 
    Post: (Body: JSON) 删和改都用Post
    {
        "username": "abc",
        "password": "dasdf",
        "nickname":"asdfasdfasd"
    }
    Delete: 
        http://localhost:9090/user/{id}
```

## Notes
- MyBatis

    一个对数据库进行增删改查的一个框架

