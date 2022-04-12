package tn.dari.spring;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import tn.dari.spring.entity.Role;
import tn.dari.spring.entity.User;
import tn.dari.spring.service.UserService;

@SpringBootApplication
@EnableScheduling
@EnableWebMvc
public class DariTnSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DariTnSpringBootApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
//	@Bean
//	CommandLineRunner run(UserService userService) {
//		return arg -> {
//			userService.saveRole(new Role(null, "ROLE_USER"));
//			userService.saveRole(new Role(null, "ROLE_ADMIN"));
//			userService.saveRole(new Role(null, "ROLE_ACHETEUR"));
//			userService.saveRole(new Role(null, "ROLE_VENDEUR"));
//
//			userService.saveRole(new Role(null, "ROLE_BAILLEUR"));
//			userService.saveRole(new Role(null, "ROLE_LOCATAIRE"));
//
//			userService.saveUser(new User(null, "hib1.farhat@esprith.tn", "hiba12", "farhat1", "hibaF", "2000000", "root",
//					new ArrayList<>()));
//			userService.saveUser(new User(null, "test1.farhat@espri.tn", "hiba2", "farhat2", "username1", "2000000",
//					"12354", new ArrayList<>()));
//			userService.saveUser(new User(null, "test2.farhat@espri.tn", "hiba3", "farhat3", "username2", "2000000",
//					"12346", new ArrayList<>()));
//			userService.saveUser(new User(null, "test3.farhat@espri.tn", "hiba4", "farhat4", "username3", "2000000",
//					"12344", new ArrayList<>()));
//
//			userService.addRoleToUser("hibaF", "ROLE_ADMIN");
//
//			userService.addRoleToUser("username1", "ROLE_ACHETEUR");
//
//			userService.addRoleToUser("hiba-fh", "ROLE_VENDEUR");
//
//	};
//	}
//	
	
	

}
