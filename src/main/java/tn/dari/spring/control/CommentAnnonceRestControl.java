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
import tn.dari.spring.service.CommentAnnonceService;
import tn.dari.spring.entity.CommentAnnonce;

@RestController
@RequestMapping("/commentAnnonce")
public class CommentAnnonceRestControl {
	@Autowired
	CommentAnnonceService CommentAnnonceService;
	
	// URL : http://Localhost:8081/SpringMVC/commentAnnonce/retrieve-All-commentAnnonce
	   @GetMapping("/retrieve-All-commentAnnonce")
 public List<CommentAnnonce> retrieveAllProduits() {
		   List<CommentAnnonce> List =CommentAnnonceService.retrieveAllCommentAnnonce();
		   return List; 
	   }
 
 // URL : http://Localhost:8081/SpringMVC/commentAnnonce/add-commentAnnonce
 @PostMapping("/add-commentAnnonce")
 @ResponseBody
 public CommentAnnonce addAnnonce(@RequestBody CommentAnnonce c) {
	   return CommentAnnonceService.addCommentAnnonce(c);}
 
//URL : http://Localhost:8081/SpringMVC/CommentAnnonce/delete-CommentAnnonce/
 
 @DeleteMapping("/delete-commentAnnonce/{id}")
 public void DeletecommentAnnonce(@PathVariable("id") Long id) {
	 CommentAnnonceService.deleteCommentAnnonce(id);
 }

}
