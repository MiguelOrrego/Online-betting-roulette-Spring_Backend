package com.rouletteonline.springboot.backend.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rouletteonline.springboot.backend.apirest.models.dao.IBetDao;
import com.rouletteonline.springboot.backend.apirest.models.entity.Bet;

@Service
public class BetServiceImpl implements IBetService {

	@Autowired
	private IBetDao betDao;

	@Override
	public Bet save(Bet bet) {
		// TODO Auto-generated method stub
		return betDao.save(bet);
	}

	@Override
	@Transactional(readOnly = false)
	public int setBetInfoByRouletteId(Long rouletteId) {
		// TODO Auto-generated method stub
		return betDao.setBetInfoByRouletteId(rouletteId);
	}

	@Override
	@Transactional(readOnly = false)
	public List<Bet> findBetsByRouletteId(Long rouletteId) {
		// TODO Auto-generated method stub
		return betDao.findByRouletteId(rouletteId);
	}

}
