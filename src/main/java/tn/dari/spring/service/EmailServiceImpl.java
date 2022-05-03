package tn.dari.spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.dari.spring.entity.Code;
import tn.dari.spring.entity.Mail;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService{

    private JavaMailSender javaMailSender;
    
    @Autowired
    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    @Async
    public void sendCodeByMail(Mail mail) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("hiba.farhat.fh@gmail.com");
        simpleMailMessage.setTo(mail.getTo());
        simpleMailMessage.setSubject("Code Activation");
        log.info("càde"+ mail.getCode());
        simpleMailMessage.setText(mail.getCode());
        javaMailSender.send(simpleMailMessage);
        
        
    }
}