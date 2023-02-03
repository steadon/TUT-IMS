package com.tut.tutims;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@MapperScan("com.tut.tutims.mapper")
@SpringBootApplication
public class TutImsApplication {
    public static void main(String[] args) {
        SpringApplication.run(TutImsApplication.class, args);
    }
}
