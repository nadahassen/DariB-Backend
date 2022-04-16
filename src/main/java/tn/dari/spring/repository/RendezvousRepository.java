package tn.dari.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.dari.spring.entity.Rendezvous;


@Repository
public interface RendezvousRepository extends JpaRepository<Rendezvous, Long>{

	

}
