package com.tut.tutims;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tut.tutims.mapper")
public class TutImsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TutImsApplication.class, args);
    }

}
