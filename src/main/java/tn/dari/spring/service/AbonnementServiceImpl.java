package tn.dari.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.dari.spring.entities.Abonnement;
import tn.dari.spring.repository.AbonnementRepository;




@Service
public class AbonnementServiceImpl implements AbonnementService{
	@Autowired
	AbonnementRepository  abonnementRepository;
	
	@Override
	public List<Abonnement> retrieveAllAbonnement() {
		// TODO Auto-generated method stub
		
		return (List<Abonnement>)abonnementRepository.findAll();
	}

	@Override
	public Abonnement addAbonnement(Abonnement a) {
		
		return abonnementRepository.save(a);
	}

	@Override
	public void deleteAbonnement(Long id) {
		// TODO Auto-generated method stub
		 abonnementRepository.deleteById(id);
	}

	@Override
	public Abonnement updateAbonnement(Abonnement a) {
		// TODO Auto-generated method stub
		return abonnementRepository.save(a);
	}

	@Override
	public Abonnement retrieveAbonnement(Long id) {
		// TODO Auto-generated method stub
		Abonnement a =abonnementRepository.findById(id).get();
		return a;
	}
}
