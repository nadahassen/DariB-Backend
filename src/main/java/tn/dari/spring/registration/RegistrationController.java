package tn.dari.spring.registration;

import lombok.*;
import tn.dari.spring.entity.User;
import tn.dari.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor

public class RegistrationController {

	@Autowired
	private UserService userService;
	@Autowired
	private RegistrationService registrationService;

	@PostMapping("/registration")
	@CrossOrigin(origins = "*")

	public User registerUser(@RequestBody User user) throws Exception {
		String tempEmail = user.getEmail();
		if (tempEmail != null && !"".equals(tempEmail)) {
			User userObj = registrationService.fetchUserByEmail(tempEmail);

			if (userObj != null) {
				throw new Exception("user with " + tempEmail + " is already exist ");
			}
		}
		User userObj = null;
		userObj = userService.saveUser(user);
		return userObj;
	}

}