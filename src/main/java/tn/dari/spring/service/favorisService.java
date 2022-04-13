package tn.dari.spring.service;

import java.util.List;

import tn.dari.spring.entity.favoris;

public interface favorisService {
	
	List<favoris> retrieveAllfavoris();

	favoris addfavoris(favoris f);

	void deletefavoris(Long id);
	
	favoris updatefavoris(favoris f,Long id);
	
	favoris retrievefavoris(Long id);
}
