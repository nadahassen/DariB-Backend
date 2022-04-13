package tn.dari.spring.control;

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

import tn.dari.spring.service.SignalerAnnonceService;
import tn.dari.spring.entity.SignalerAnnonce;
@RestController
@RequestMapping("/SignalerAnnonce")
public class SignalerAnnonceRestControl {
	@Autowired
	SignalerAnnonceService SignalerAnnonceService;
	
	// URL : http://Localhost:8081/SpringMVC/SignalerAnnonce/retrieve-All-SignalerAnnonce
	   @GetMapping("/retrieve-All-SignalerAnnonce")
 public List<SignalerAnnonce> retrieveAllProduits() {
		   List<SignalerAnnonce> List =SignalerAnnonceService.retrieveAllSignalerAnnonce();
		   return List; 
	   }
 
 // URL : http://Localhost:8081/SpringMVC/SignalerAnnonce/add-SignalerAnnonce
 @PostMapping("/add-SignalerAnnonce")
 @ResponseBody
 public SignalerAnnonce addAnnonce(@RequestBody SignalerAnnonce l) {
	   return SignalerAnnonceService.addSignalerAnnonce(l);}
 
//URL : http://Localhost:8081/SpringMVC/SignalerAnnonce/delete-SignalerAnnonce/
 
 @DeleteMapping("/delete-SignalerAnnonce/{id}")
 public void DeleteSignalerAnnonce(@PathVariable("id") Long id) {
	 SignalerAnnonceService.deleteSignalerAnnonce(id);
 }

}
