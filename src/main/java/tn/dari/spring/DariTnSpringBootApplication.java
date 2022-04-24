package tn.dari.spring;

import java.util.ArrayList;
import java.util.Collection;

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
//			userService.saveUser(new User("hiba", "farhat", "hiba-fh", "hiba-farhat@esprit.tn", "000000", null, "root",
//					"ariana", false, new ArrayList<>()));
//
//			userService.saveUser(new User("rihab", "haddad", "rihab-ha", "rihab.haddad@esprit.tn", "000000", null,
//					"root", "ariana", false, new ArrayList<>()));
//			userService.saveUser(new User("cyrine", "belguith", "cyrine-bl", "cyrine.bel@esprit.tn", "000000", null,
//					"root", "ariana", false, new ArrayList<>()));
//			userService.saveUser(new User("siwar", "benkraiem", "siwar-bk", "siwar-benkraiem@esprit.tn", "000000", null,
//					"root", "ariana", false, new ArrayList<>()));
//			userService.saveUser(new User("syrine", "benhassine", "syrine-bh", "syrine-bh@esprit.tn", "000000", null,
//					"root", "ariana", false, new ArrayList<>()));
//			userService.saveUser(new User("nada", "hassan", "nada-hs", "nada.hassen@esprit.tn", "000000", null, "root",
//					"ariana", false, new ArrayList<>()));
//
//			userService.addRoleToUser("hiba-fh", "ROLE_ADMIN");
//
//			userService.addRoleToUser("rihab-ha", "ROLE_ACHETEUR");
//
//			userService.addRoleToUser("hiba-fh", "ROLE_VENDEUR");
//			userService.addRoleToUser("cyrine-bl", "ROLE_VENDEUR");
//			userService.addRoleToUser("siwar-bk", "ROLE_VENDEUR");
//			userService.addRoleToUser("nada-hs", "ROLE_LOCATAIRE");
//			userService.addRoleToUser("syrine-bh", "ROLE_LOCATAIRE");
//
//		};
//	}

}
