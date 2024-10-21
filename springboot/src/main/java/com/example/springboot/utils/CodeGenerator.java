package com.example.springboot.utils;

import java.nio.file.Paths;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
// import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

// 代码生成器
public class CodeGenerator {

    public static void generator(){
        //Database 设置
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/stev", "root", "steven123")
        .globalConfig(builder -> builder
                .author("luoxisteven")
                .outputDir("/Users/stev/Desktop/Java Projects/Management_System/springboot/src/main/java/")
                
                .commentDate("2024-10-18")
        )
        .packageConfig(builder -> builder
                .parent("com.example.springboot")
                .entity("entity")
                .mapper("mapper")
                .service("service")
                .serviceImpl("service.impl")
                .xml("mapper.xml")
        )
        .strategyConfig(builder -> builder
                .addInclude("sys_user")
                .addTablePrefix("sys_")
                .entityBuilder()
                .enableLombok()
        )
        // .templateEngine(new FreemarkerTemplateEngine())
        .execute();
    }

    public static void main(String[] args) {
        generator();
    }
}
