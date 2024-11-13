package com.eTag.back;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.eTag.back.*.mapper")
@EnableTransactionManagement
public class ETagBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ETagBackApplication.class, args);
    }

}
