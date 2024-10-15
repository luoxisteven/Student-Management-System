package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.User;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.service.UserService;

@RestController // Controller
@RequestMapping("/user") // Localhost:9090/user才能访问
public class UserController{

    @Autowired //无需构造方法自动注入 
	private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @PostMapping()
    public Integer save(@RequestBody User user){ //RequestBody把前台的JSON对象转换成Java对象
        // 新增或者更新
        return userService.save(user);
    }

    @GetMapping() //localhost:9090/user/
	public List<User> index(){
        // return userMapper.findAll();
        List<User> all = userMapper.findAll();
		return all;
	}

    @DeleteMapping("/{id}") //PathVariable
    public Integer delete(@PathVariable Integer id){ //PathVariable 就是 /{id}
        return userMapper.deleteById(id);
    }

}