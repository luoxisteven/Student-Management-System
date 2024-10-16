package com.example.springboot.controller;

import java.util.List;
// import java.util.Map;
// import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.entity.User;
// import com.example.springboot.mapper.UserMapper;
import com.example.springboot.service.UserService;

@RestController // Controller
@RequestMapping("/user") // Localhost:9090/user才能访问
public class UserController{

    // @Autowired //无需构造方法自动注入 
	// private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @PostMapping  //Post:localhost:9090/user/
    public Boolean save(@RequestBody User user){ //RequestBody把前台的JSON对象转换成Java对象
        // 新增或者更新
        return userService.saveUser(user); //MyBatis-Plus接口 extends ServiceImpl<UserMapper, User>
    }

    @GetMapping //Get:localhost:9090/user/
	public List<User> findAll(){
        // List<User> all = userMapper.findAll();
		// return all;
        return userService.list(); //MyBatis-Plus接口 extends ServiceImpl<UserMapper, User>
	}

    // 普通MyBatis
    // // 分页查询, 接口为/user/page?pageNum=1&pageSize=10
    // // @RequestParam 接收
    // @GetMapping("/page") 
    //     public Map<String, Object> findPage(@RequestParam Integer pageNum, 
    //                                         @RequestParam Integer pageSize,
    //                                         @RequestParam String username,
    //                                         @RequestParam String email,
    //                                         @RequestParam String address){
    //     pageNum = (pageNum - 1) * pageSize;

    //     Integer total = userMapper.selectTotal(username, email, address);
    //     List<User> data = userMapper.selectPage(pageNum, pageSize, username, email, address);
    //     Map<String, Object> res = new HashMap<>();
    //     res.put("data", data);
    //     res.put("total", total);
    //     return res;
        
	// }  

    // MyBatis-Plus
    @GetMapping("/page") 
        public IPage<User> findPage(@RequestParam Integer pageNum, 
                                            @RequestParam(defaultValue = "") Integer pageSize,
                                            @RequestParam(defaultValue = "") String username,
                                            @RequestParam(defaultValue = "") String nickname,
                                            @RequestParam(defaultValue = "") String phone,
                                            @RequestParam(defaultValue = "") String email,
                                            @RequestParam(defaultValue = "") String address){
        IPage<User> page = new Page<>(pageNum, pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (!"".equals(username)){
            queryWrapper.like("username", username);
        }
        if (!"".equals(nickname)){
            queryWrapper.like("nickname", nickname);
        }
        if (!"".equals(email)){
            queryWrapper.like("email", email);
        }
        if (!"".equals(address)){
            queryWrapper.like("address", address);
        }
        if (!"".equals(phone)){
            queryWrapper.like("phone", phone);
        }
        
        // queryWrapper.or().like("address", address);
        return userService.page(page, queryWrapper);
     }

    @DeleteMapping("/{id}") //Get:localhost:9090/user/{id}
    public boolean delete(@PathVariable Integer id){ //PathVariable 就是 /{id}
        // return userMapper.deleteById(id); //普通MyBatis:int
        return userService.removeById(id); //MyBatis-Plus接口 extends ServiceImpl<UserMapper, User>
        
    }

}