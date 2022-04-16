package tn.dari.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tn.dari.spring.entity.DemandeVisite;
import tn.dari.spring.entity.Image;
import tn.dari.spring.entity.Property;
import tn.dari.spring.entity.User;
import tn.dari.spring.repository.DemandeVisiteRepository;
import tn.dari.spring.repository.PropertyRepository;
import tn.dari.spring.repository.UserRepository;

@Service
public class DemandeVisiteImpl implements DemandeVisiteService {
@Autowired
DemandeVisiteRepository demandeVisiteRepository;
@Autowired
UserRepository userRepository;
@Autowired
ServiceImage imageService;
@Autowired 
PropertyRepository propertyRepository;

	@Override
	public List<DemandeVisite> retrieveAllVisitsByUser(User user) {
		// TODO Auto-generated method stub
		return demandeVisiteRepository.findAllByUser(user);
	}

	@Override
	public DemandeVisite retrieveDemandeVisite(Long id) {
		// TODO Auto-generated method stub
		return demandeVisiteRepository.findById(id).get();
	}

	@Override
	public DemandeVisite updateDemandeVisite(DemandeVisite f) {
		// TODO Auto-generated method stub
		 return demandeVisiteRepository.save(f);
	}

	@Override
	public DemandeVisite addDemandeVisite(DemandeVisite f, Long idUser,MultipartFile cin,MultipartFile garant ,Long idProperty) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(idUser).orElse(null);
		f.setUser(user);
		Property property = propertyRepository.findById(idProperty).orElse(null);
		f.setProperty(property);
// image 
		
		f.setCin(cin.getOriginalFilename());
		f.setGarant(garant.getOriginalFilename());

				
			 return demandeVisiteRepository.save(f);
	
	}

	@Override
	public void deleteDemande(Long id) {
		// TODO Auto-generated method stub
		demandeVisiteRepository.deleteById(id);
	}

	

}
