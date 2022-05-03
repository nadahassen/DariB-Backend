package tn.dari.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.dari.spring.entity.Code;

@Repository
public interface CodeRepository extends CrudRepository<Code,Long>{
	Code findByCode(String code);

}
