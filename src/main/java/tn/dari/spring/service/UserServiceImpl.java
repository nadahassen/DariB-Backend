package tn.dari.spring.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tn.dari.spring.entity.Role;
import tn.dari.spring.entity.User;
import tn.dari.spring.repository.RoleRepository;
import tn.dari.spring.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j

public class UserServiceImpl implements UserService, UserDetailsService {
//	public class UserServiceImpl implements UserService {

	private final UserRepository userRepo;
	private final RoleRepository roleRepo;
	private final PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepo.findByUsername(username);
		if (user == null) {
			log.error("user not found in the database");
			throw new UsernameNotFoundException("user not found");

		} else {
			log.info("user {} found in the database", username);
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		});
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				authorities);

	}

	@Override
	public List<User> getUsers() {
		log.info("fetching all users");

		// TODO Auto-generated method stub
		return (List<User>) userRepo.findAll();
	}

	@Override
	public Role saveRole(Role role) {
//		// TODO Auto-generated method stub
		log.info("saving new role {} to the database", role.getName());

		return roleRepo.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		log.info("adding role {} to user {}", roleName, username);

		User user = userRepo.findByUsername(username);
		Role role = roleRepo.findByName(roleName);
		user.getRoles().add(role);

	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		userRepo.deleteById(id);

	}

	@Override
	public User updateUser(User user, Long id) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public User getUser(String username) {
		log.info("fetching user {} ", username);

		// TODO Auto-generated method stub
		return userRepo.findByUsername(username);
	}



	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		log.info("saving new user {} to the database", user.getNom());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

}
