package tn.dari.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.dari.spring.entity.Credit;
import tn.dari.spring.repository.CreditRepository;


@Service
public class CreditServiceImpl implements CreditService {
	

	@Autowired
	CreditRepository creditRepository;

	@Override
	public List<Credit> retrieveAllCredits() {
		return (List<Credit>) creditRepository.findAll();
	}

	@Override
	public Credit addCredit(Credit c) {
		Credit credit = creditRepository.save(c);
		return credit;
	}

	@Override
	public void deleteCredit(Long id) {
		creditRepository.deleteById(id);
		
	}

	@Override
	public Credit updateCredit(Credit c, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Override public List<Credit> BestOffre() { return (List<Credit>)
	 * creditRepository.findAllByOrderByNmbDesc(); }
	 */

	@Override
	public Credit retrieveCreditById(Long id) {
		Credit credit = creditRepository.findById(id).get();
		return credit;
	}
	
	


}
