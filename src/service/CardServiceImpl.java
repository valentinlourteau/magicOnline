package service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.CardDao;
import dao.GenericJpaDaoImpl;
import entities.Card;

@Stateless
@LocalBean
public class CardServiceImpl extends GenericJpaDaoImpl<Card> implements CardService {
	
	@Inject
	CardDao cardDao;

	@Override
	public Card findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Card> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long countAll() {
		return cardDao.countAll();
	}

	@Override
	public void removeAll() {
		cardDao.removeAll();
	}

	@Override
	public Set<Card> findAllToSet() {
		return cardDao.findAll().stream().collect(Collectors.toSet());
	}

}
