package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(
        sqlSessionFactoryRef = "sqlSessionFactory",
        sqlSessionTemplateRef = "sqlSessionTemplate"
)
@SpringBootApplication
public class DemoWebclient1Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoWebclient1Application.class, args);
    }

}
