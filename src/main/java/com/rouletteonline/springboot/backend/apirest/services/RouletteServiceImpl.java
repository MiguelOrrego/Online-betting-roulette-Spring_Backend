package com.rouletteonline.springboot.backend.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.rouletteonline.springboot.backend.apirest.models.dao.IRouletteDao;
import com.rouletteonline.springboot.backend.apirest.models.entity.Roulette;

@Service
public class RouletteServiceImpl implements IRouletteService {

	@Autowired
	private IRouletteDao rouletteDao;

	@Override
	@Transactional(readOnly = true)
	public List<Roulette> finAll() {
		// TODO Auto-generated method stub
		return (List<Roulette>) rouletteDao.findAll();
	}

	@Override
	public Roulette save(Roulette roulette) {
		// TODO Auto-generated method stub
		return rouletteDao.save(roulette);
	}

	@Override
	public Roulette findById(Long id) {
		// TODO Auto-generated method stub
		return rouletteDao.findById(id).orElse(null);
	}

}
