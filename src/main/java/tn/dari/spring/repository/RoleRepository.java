package tn.dari.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.dari.spring.entity.ERole;
import tn.dari.spring.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role,Long> {

	Role findByName(ERole roleAdmin);

}