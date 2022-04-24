package tn.dari.spring.registration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import lombok.Getter;
import lombok.Setter;
import tn.dari.spring.entity.Role;

@Getter
@Setter
public class RegistrationRequest {

	private  String nom;
	private  String prenom;
	private  String username;
	private  String email;
	private String address;
	private  String tel;
	private  String password;
	private LocalDateTime joinedAt;
	private Collection<Role> roles = new ArrayList<>();
	
	

	
	
}
