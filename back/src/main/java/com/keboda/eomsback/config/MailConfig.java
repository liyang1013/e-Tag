package com.keboda.eomsback.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {

    @Bean(name = "HikVision")
    public JavaMailSender getMailSender1() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("172.16.200.64");
        mailSender.setPort(587);
        mailSender.setUsername("hikvision_system@keboda.com");
        mailSender.setPassword("kbd123456*");
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.ssl.enable", "true");
        return mailSender;
    }

    @Bean(name = "Teams")
    public JavaMailSender getMailSender2() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("172.16.200.64");
        mailSender.setPort(587);
        mailSender.setUsername("teams_admin@keboda.com");
        mailSender.setPassword("kbd123456*");
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.ssl.enable", "true");
        return mailSender;
    }

    @Bean(name = "ITSupport")
    public JavaMailSender getMailSender3() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("172.16.200.64");
        mailSender.setPort(587);
        mailSender.setUsername("ITsupport@keboda.com");
        mailSender.setPassword("kbd123456*");
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.ssl.enable", "true");
        return mailSender;
    }
}