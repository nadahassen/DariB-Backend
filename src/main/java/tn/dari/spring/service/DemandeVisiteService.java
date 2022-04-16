package tn.dari.spring.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import tn.dari.spring.entity.DemandeVisite;
import tn.dari.spring.entity.User;


public interface DemandeVisiteService {

	List<DemandeVisite> retrieveAllVisitsByUser(User user);
	DemandeVisite retrieveDemandeVisite(Long id);
	DemandeVisite updateDemandeVisite(DemandeVisite f);
	DemandeVisite addDemandeVisite(DemandeVisite f, Long idUser,MultipartFile cin,MultipartFile garant,Long idProperty);
	void deleteDemande(Long id);


}
