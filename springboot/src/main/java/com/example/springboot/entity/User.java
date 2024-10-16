package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Getter & Setter
@NoArgsConstructor //无参构造方法
@AllArgsConstructor //有参构造方法
@TableName(value = "sys_user")  //表名
public class User {
    @TableId(value = "id") //主键
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
