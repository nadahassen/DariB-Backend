package tn.dari.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.dari.spring.entity.Credit;

public interface CreditRepository extends CrudRepository<Credit, Long> {
	
	//List<Credit> findAllByOrderByNmbDesc();

}
