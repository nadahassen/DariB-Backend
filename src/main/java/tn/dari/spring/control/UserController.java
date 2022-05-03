package tn.dari.spring.control;

import java.net.PasswordAuthentication;
import java.util.List;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tn.dari.spring.entity.Code;
import tn.dari.spring.entity.Mail;
import tn.dari.spring.entity.Message;
import tn.dari.spring.entity.User;
import tn.dari.spring.repository.UserRepository;
import tn.dari.spring.service.EmailService;
import tn.dari.spring.service.UserService;
import tn.dari.spring.userFunctions.AccountResponse;
import tn.dari.spring.userFunctions.ResetPassword;
import tn.dari.spring.userFunctions.UserCode;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin(origins ="*")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	UserRepository userRepo;
	@Autowired
	EmailService emailService;

	// URL : http://localhost:8081/SpringMVC/User/retrieve-All-Users
	@GetMapping("/allUsers")
	public List<User> retrieveAllUsers() {
		List<User> List = userService.getUsers();
		return List;
	}

	// URL : http://localhost:8081/SpringMVC/User/add-User
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@PostMapping("/role/addToUser")
	public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form) {
		userService.addRoleToUser(form.getUsername(), form.getRoleName());
		return ResponseEntity.ok().build();

	}

	// URL : http://Localhost:8081/SpringMVC/User/modify-User/{id}
	@PutMapping("/modifUser")
	public User updateUser(@RequestBody User p) {

		return userService.updateUser(p);
	}

	@PutMapping("/lockUser/{id}/{status}")
	public void lockUser( @PathVariable("id") Long id,@PathVariable("status") boolean status) {

		 userService.lockUser(id,status);
	}

	// URL : http://Localhost:8081/SpringMVC/User/delete-User/
	@DeleteMapping("/deleteUser/{id}")
	public void DeleteUser(@PathVariable("id") Long id) {
		userService.deleteUser(id);
	}

	 @PostMapping("/checkEmail")
	    public AccountResponse resetPasswordEmail(@RequestBody ResetPassword resetPassword){
	        User user = this.userService.getUserByMail(resetPassword.getEmail());
	        AccountResponse accountResponse = new AccountResponse();
	        if(user != null){
	        	 

	        	String code = UserCode.getCode();
	            Mail mail = new Mail(resetPassword.getEmail(),code);
	            emailService.sendCodeByMail(mail);
	            user.getCode().setCode(code);
	            this.userService.updateUser(user);
	            accountResponse.setResult(1);
	        } else {
	            accountResponse.setResult(0);
	        }
	        return accountResponse;
	    }


}

@Data
class RoleToUserForm {
	private String username;
	private String roleName;
}