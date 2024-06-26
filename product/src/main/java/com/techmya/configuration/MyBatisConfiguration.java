package com.techmya.configuration;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.techmya", annotationClass = Mapper.class)
public class MyBatisConfiguration {
}
