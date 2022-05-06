package tn.dari.spring.service;

import java.util.List;
import tn.dari.spring.entity.ERole;
import tn.dari.spring.entity.Role;
import tn.dari.spring.entity.User;

public interface UserService {

	List<User> getUsers();

	User saveUser(User user);

	Role saveRole(Role role);

	void addRoleToUser(String username, String roleName);

	void deleteUser(Long id);

	User updateUser(User user);

	void lockUser(Long id, boolean status);

	User getUser(String username);

	Role updateRole(Role p, Long id);

	void deleteRole(Long id);

	void updatePassword(String emailUser, String newPassword, String confirmPassword);

	void forgotpass(String emailuser);

	List<Role> getRoles();

	void addRoleToUser(String username, ERole roleName);

	boolean ifEmailExist(String email);

	User getUserByMail(String mail);
}