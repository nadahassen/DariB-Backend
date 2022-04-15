package tn.dari.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.dari.spring.entity.Banque;

public interface BanqueRepository  extends CrudRepository<Banque, Long>  {
	
	@Query("SELECT nombanque FROM Banque")
    public List<String> getAllBankByNames();

}
