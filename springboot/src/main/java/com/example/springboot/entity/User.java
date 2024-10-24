package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data //Getter & Setter
@NoArgsConstructor //无参构造方法
@AllArgsConstructor //有参构造方法
@TableName(value = "sys_user")  //表名
@ToString
public class User {
    //value:主键在数据的名字 Auto:MyBatis-Plus 不会干预主键的生成，而是依赖数据库本身来生成主键。
    @TableId(value = "id", type = IdType.AUTO) 
    private Integer id;
    private String username;
    @JsonIgnore //password不展示给前端
    private String password;
    private String nickname;
    private String email;
    private String phone;
    @TableField(value = "address") //数据库字段别名，可以不与java的一致
    private String address;
    
}
