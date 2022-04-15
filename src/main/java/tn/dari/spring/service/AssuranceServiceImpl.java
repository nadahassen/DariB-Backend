package tn.dari.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.dari.spring.entities.Abonnement;
import tn.dari.spring.entities.Assurance;

import tn.dari.spring.repository.AssuranceRepository;
@Service
public class AssuranceServiceImpl implements AssuranceService{
	
	@Autowired
	 AssuranceRepository   assuranceRepository;

	@Override
	public List<Assurance> retrieveAllAssurance() {
		// TODO Auto-generated method stub
		return (List<Assurance>)assuranceRepository.findAll();
	}

	@Override
	public Assurance addAssurance(Assurance a) {
		// TODO Auto-generated method stub
		return assuranceRepository.save(a);
	}

	@Override
	public void deleteAssurance(Long id) {
		// TODO Auto-generated method stub
		assuranceRepository.deleteById(id);
	}

	@Override
	public Assurance updateAssurance(Assurance a) {
		// TODO Auto-generated method stub
		return assuranceRepository.save(a);
	}

	@Override
	public Assurance retrieveAssurance(Long id) {
		// TODO Auto-generated method stub
		Assurance a =assuranceRepository.findById(id).get();
		return a;
	}

}
