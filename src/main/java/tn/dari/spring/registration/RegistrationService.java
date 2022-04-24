package tn.dari.spring.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.dari.spring.entity.User;
import tn.dari.spring.repository.UserRepository;
@Service
public class RegistrationService {
	@Autowired
	public UserRepository userRepo;

	User fetchUserByEmail(String tempEmail) {
		return userRepo.findByEmail(tempEmail);

	}

}
