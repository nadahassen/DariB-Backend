package tn.dari.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.dari.spring.entity.Rendezvous;
import tn.dari.spring.entity.User;
import tn.dari.spring.repository.RendezvousRepository;
import tn.dari.spring.repository.UserRepository;

@Service
public class RendezvousServiceImpl implements RendezvousService{
	@Autowired
RendezvousRepository rendezvousRepository;
	@Autowired
	UserRepository userRepository;
	@Override
	public List<Rendezvous> retrieveAllRdv() {
		// TODO Auto-generated method stub
		return (List<Rendezvous>) rendezvousRepository.findAll();
	}

	@Override
	public Rendezvous addRdv(Rendezvous rdv, Long idUser) {
		
		// TODO Auto-generated method stub
User user =userRepository.findById(idUser).orElse(null);
		
rdv.setUser(user);
		return rendezvousRepository.save(rdv);
	}

	@Override
	public void deleteRdv(Long idRdv) {
		rendezvousRepository.deleteById(idRdv);
		
	}

	@Override
	public Rendezvous updateRdv(Rendezvous r) {
		// TODO Auto-generated method stub
		return rendezvousRepository.save(r);
	}

	@Override
	public Rendezvous retrieveRdv(Long idRdv) {
		Rendezvous r = rendezvousRepository.findById(idRdv).get();
		return r;		
	}

}
