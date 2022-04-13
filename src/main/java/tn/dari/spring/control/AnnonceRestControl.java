package tn.dari.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.dari.spring.service.AnnonceService;
import tn.dari.spring.entity.Annonce;

@RestController
@RequestMapping("/Annonce")
public class AnnonceRestControl {
	@Autowired
	AnnonceService AnnonceService;

	// URL : http://Localhost:8081/SpringMVC/Annonce/retrieve-All-Annonces
	@GetMapping("/retrieve-All-Annonces")
	public List<Annonce> retrieveAllAnnonces() {
		List<Annonce> List = AnnonceService.retrieveAllAnnonces();
		return List;
	}

	// URL : http://Localhost:8081/SpringMVC/Annonce/add-Annonce
	@PostMapping("/add-Annonce")
	@ResponseBody
	public ResponseEntity<String> addAnnonce(@RequestBody Annonce annonce) {
		if (VerifyAnnonce(annonce)=="succes")
		{
			return ResponseEntity.ok("Annonce Ajouté avec succés");
		}
		else {
			return ResponseEntity.status(202).body(VerifyAnnonce(annonce));
		}
	
	}

	private String VerifyAnnonce(Annonce annonce) {
		if (annonce.getDescription() == "") {
			return "le champ description est manquant";
		}
		if (annonce.getSurface() == 0 || annonce.getSurface() <0 ) {
			return "le champ surface ne doit pas etre zero ou negatif";
		}
		if (annonce.getLocation() == "") {
			return "le champlocation est manquant";
		}
		if (annonce.getPrice() == 0  || annonce.getPrice() <0  ) {
			return "le champ surface ne doit pas etre zero ou negatif";
		}
		if (annonce.getImage() == ""  ) {
			return "Il faut ajouter une image";
		}
		if (annonce.getRoomsNum() == 0  ) {
			return "le champ nombre de chzambre ne doit pas etre zero ou negatif";
		}
	
		return "succes";
	}

	// URL : http://Localhost:8081/SpringMVC/Annonce/modify-Annonce
	@PutMapping("/modify-Annonce")
	public ResponseEntity<String> updateAnnonce(@RequestBody Annonce annonce) {
		if (VerifyAnnonce(annonce)=="succes")
		{
			return ResponseEntity.ok("Annonce Ajouté avec succés");
		}
		else {
			return ResponseEntity.status(202).body(VerifyAnnonce(annonce));
		}
		
	
	}

	// URL : http://Localhost:8081/SpringMVC/Annonce/delete-Annonce/
	@DeleteMapping("/delete-Annonce/{id}")
	public ResponseEntity<String>  DeleteAnnonce(@PathVariable("id") Long id) {
		AnnonceService.deleteAnnonce(id);
		return ResponseEntity.ok("Annonce supprimé avec succés");
	}

}
