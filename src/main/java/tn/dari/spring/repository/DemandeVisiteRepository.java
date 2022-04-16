package tn.dari.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.dari.spring.entity.DemandeVisite;
import tn.dari.spring.entity.User;

@Repository
public interface DemandeVisiteRepository extends JpaRepository<DemandeVisite, Long>{

	List<DemandeVisite> findAllByUser(User user);

}
