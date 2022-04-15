package tn.dari.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.Api;
import tn.dari.spring.entities.Abonnement;
import tn.dari.spring.service.AbonnementService;

@RestController
@RequestMapping("/abonnement")
@Api(tags="Gestion des abonnements")
public class AbonnementResetController {
	@Autowired
	AbonnementService AbonnementService;
	
	
	//URL : http://localhost:8081/DariTn/Abonnement/retrieve-all-Abonnement
	@GetMapping("/retrieve-all-Abonnement")
	public List<Abonnement> retrieveAllAbonnements() {
		List<Abonnement> list = AbonnementService.retrieveAllAbonnement();
		return list;
	}
	//URL : http://localhost:8081/DariTn/Abonnement/add-Abonnement
		@ResponseBody
		@PostMapping("/add-abonnement")
		public Abonnement addAbonnement(@RequestBody Abonnement A) {
			return AbonnementService.addAbonnement(A);
		}
		
		//URL : http://localhost:8081/DariTn/Abonnement/update-Abonnement
		@PostMapping("/update-abonnement")
		public Abonnement updAbonnement(@RequestBody Abonnement A) {
			return AbonnementService.updateAbonnement(A);
		}
		
		//URL : http://localhost:8081/DariTn/Abonnement/delete-Abonnement
		@DeleteMapping("/delete-abonnement/{id}")
		public void deleteAbonnement(@PathVariable("id") Long id) {
			AbonnementService.deleteAbonnement(id);
		}

}
