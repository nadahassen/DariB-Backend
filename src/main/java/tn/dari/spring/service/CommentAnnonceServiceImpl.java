package tn.dari.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.dari.spring.entity.CommentAnnonce;
import tn.dari.spring.repository.CommentAnnonceRepository;

@Service
public class CommentAnnonceServiceImpl  implements  CommentAnnonceService {
	@Autowired
 CommentAnnonceRepository CommentAnnonceRepository;
	@Override
	public List<CommentAnnonce> retrieveAllCommentAnnonce() {

		return (List<CommentAnnonce>)CommentAnnonceRepository .findAll() ;
	}

	@Override
	public CommentAnnonce addCommentAnnonce(CommentAnnonce c) {
		return CommentAnnonceRepository.save(c);
	}

	@Override
	public void deleteCommentAnnonce(Long id) {
		CommentAnnonceRepository.deleteById(id);
		
	}

}
