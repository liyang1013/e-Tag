package com.keboda.eomsback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.math.BigDecimal;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.keboda.eomsback.*.mapper")
@EnableTransactionManagement
public class EomsBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(EomsBackApplication.class, args);
    }

}
