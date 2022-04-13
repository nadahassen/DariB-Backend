package tn.dari.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.dari.spring.entity.favoris;
import tn.dari.spring.repository.favorisRepository;

@Service
public class favorisServiceImpl implements favorisService {
	
	@Autowired
	favorisRepository favorisRepository;

	@Override
	public List<favoris> retrieveAllfavoris() {
		return (List<favoris>) favorisRepository.findAll();
		
	}

	@Override
	public favoris addfavoris(favoris f) {
		return favorisRepository.save(f);
	}

	@Override
	public void deletefavoris(Long id) {
		favorisRepository.deleteById(id);
	}

	@Override
	public favoris updatefavoris(favoris f,Long id) {
		return favorisRepository.save(f);
	}

	@Override
	public favoris retrievefavoris(Long id) {
		favoris f=  favorisRepository.findById(id).get();
		return f;
	}



}
