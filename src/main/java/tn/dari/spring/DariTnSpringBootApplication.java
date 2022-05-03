package tn.dari.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import tn.dari.spring.entity.Mail;
import tn.dari.spring.service.EmailService;



@SpringBootApplication
@EnableWebMvc
@EnableAsync
public class DariTnSpringBootApplication {
//	@Autowired
//EmailService emailService;
	public static void main(String[] args) {
		SpringApplication.run(DariTnSpringBootApplication.class, args);
	}

//@EventListener(ApplicationReadyEvent.class)
//	public void sendCv() {
//		Mail mail = new Mail();
//		mail.setCode("CV");
//		mail.setTo("hibafarhat998@gmail.com");
//		mail.setText("success");
//		emailService.sendCodeByMail(mail);
//		System.out.println("ok");	
//	}

}
