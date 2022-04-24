package tn.dari.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.dari.spring.entity.User;

public interface UserRepository extends CrudRepository<User,Long> {

	User findByUsername(String username);
	User findByEmail(String email);
	

}
