package tn.dari.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.dari.spring.entities.Abonnement;


@Repository
public interface AbonnementRepository  extends CrudRepository<Abonnement,Long> {

}
