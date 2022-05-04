package tn.dari.spring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;




@SpringBootApplication
@EnableWebMvc
@EnableAsync
public class DariTnSpringBootApplication {
//	@Autowired
//EmailService emailService;
	public static void main(String[] args) {
		SpringApplication.run(DariTnSpringBootApplication.class, args);
	}



}
