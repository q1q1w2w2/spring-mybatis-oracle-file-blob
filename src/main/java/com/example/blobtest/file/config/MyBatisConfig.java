package com.example.blobtest.file.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.example.blobtest.file.repository")
public class MyBatisConfig {
}
