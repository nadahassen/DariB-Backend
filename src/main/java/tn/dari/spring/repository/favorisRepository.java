package tn.dari.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.dari.spring.entity.favoris;

@Repository
public interface favorisRepository extends CrudRepository<favoris, Long> {

}