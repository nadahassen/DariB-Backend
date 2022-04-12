package tn.dari.spring.service;

import java.util.List;

import tn.dari.spring.entities.Abonnement;





public interface AbonnementService {
	List<Abonnement> retrieveAllAbonnement ();

	Abonnement  addAbonnement (Abonnement a) ;

	void deleteAbonnement (Long id);

	Abonnement  updateAbonnement (Abonnement  a);

	Abonnement  retrieveAbonnement (Long id);
}
