package tn.dari.spring.service;

import java.util.List;

import tn.dari.spring.entity.Role;
import tn.dari.spring.entity.User;


public interface UserService {

	List<User> getUsers();

	User saveUser(User user);
	Role saveRole(Role role);
	void addRoleToUser(String username, String roleName);
	
	void deleteUser(Long id);

	User updateUser(User user, Long id);

//	User retrieveUser(Long id);

	User getUser(String username);

}
