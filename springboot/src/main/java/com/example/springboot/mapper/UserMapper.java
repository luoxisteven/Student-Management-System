package com.example.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
// import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Delete;

import com.example.springboot.entity.User;

@Mapper
public interface UserMapper{ 

    @Select("select * from sys_user;")
    List<User> findAll();

    @Insert("INSERT INTO sys_user(username,password,nickname,email,phone,address) VALUES (#{username},#{password},#{nickname},#{email},#{phone},#{address});")    
    int insert(User user);

    // @Update("UPDATE sys_user set username = #{username}, password = #{password}, nickname = #{nickname}, email = #{email}, phone = #{phone}, address = #{address} where id = #{id}")
    // 这个已经在User.xml上有动态的xml
    int update(User user);

    @Delete("DELETE FROM sys_user where id = #{id}")
    Integer deleteById(@Param("id") Integer id); //Param里的"id"，跟上面#{id}是一致的

}
