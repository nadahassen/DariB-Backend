package tn.dari.spring.service;

import java.util.List;

import tn.dari.spring.entity.CommentAnnonce;



public interface CommentAnnonceService {
	List<CommentAnnonce> retrieveAllCommentAnnonce();
	CommentAnnonce addCommentAnnonce(CommentAnnonce c);

	void deleteCommentAnnonce(Long id);

	
}
