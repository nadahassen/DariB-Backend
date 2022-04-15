package tn.dari.spring.service;

import java.util.List;

import tn.dari.spring.entity.Banque;

public interface BanqueService {
	
	List<Banque> retrieveAllBanques();
	Banque addBanque(Banque b);
	void deleteBanque(Long id);
	Banque updateBanque(Banque b, Long id);
	Banque retrieveBanqueById(Long id);
	List<String> getAllBankByNames();

}
