package com.example.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Getter & Setter
@NoArgsConstructor //无参构造方法
@AllArgsConstructor //有参构造方法
public class User {
    private Integer id;
    private String username;
    @JsonIgnore //password不展示给前端
    private String password;
    private String nickname;
    private String email;
    private String phone;
    private String address;
    
}
