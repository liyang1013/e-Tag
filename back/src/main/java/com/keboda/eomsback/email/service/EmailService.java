package com.keboda.eomsback.email.service;

import com.keboda.eomsback.email.pojo.EmailBody;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender hikvisionSender;
    private final JavaMailSender teamsSender;

    private final JavaMailSender itSupportSend;

    public EmailService(@Qualifier("HikVision") JavaMailSender hikVision,@Qualifier("Teams") JavaMailSender teams, @Qualifier("ITSupport") JavaMailSender itSupport) {
        this.hikvisionSender = hikVision;
        this.teamsSender = teams;
        this.itSupportSend = itSupport;
    }


    public String hikvisionSend(EmailBody emailBody) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("hikvision_system@keboda.com");
        message.setTo(emailBody.getTo());
        if(emailBody.getCc() != null) message.setCc(emailBody.getCc());
        message.setSubject(emailBody.getSubject());
        message.setText(emailBody.getText());
        hikvisionSender.send(message);
        return "发送邮件成功";
    }

    public String teamsSend(EmailBody emailBody) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("teams_admin@keboda.com");
        message.setTo(emailBody.getTo());
        if(emailBody.getCc() != null) message.setCc(emailBody.getCc());
        message.setSubject(emailBody.getSubject());
        message.setText(emailBody.getText());
        teamsSender.send(message);
        return "发送邮件成功";
    }

    public String itSupportSend(EmailBody emailBody) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ITsupport@keboda.com");
        message.setTo(emailBody.getTo());
        if(emailBody.getCc() != null) message.setCc(emailBody.getCc());
        message.setSubject(emailBody.getSubject());
        message.setText(emailBody.getText());
        itSupportSend.send(message);
        return "发送邮件成功";
    }
}
