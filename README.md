# Management System
- @Author: @luoxisteven
- @Teacher: @qinge (@Copyright Reserve)

This is a frontend and backend project for a student management system from https://www.bilibili.com/video/BV1U44y1W77D/.

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

