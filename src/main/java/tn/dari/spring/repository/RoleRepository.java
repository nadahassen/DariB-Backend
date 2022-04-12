package tn.dari.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.dari.spring.entity.Role;

public interface RoleRepository extends CrudRepository<Role,Long> {

	Role findByName(String name);

}
