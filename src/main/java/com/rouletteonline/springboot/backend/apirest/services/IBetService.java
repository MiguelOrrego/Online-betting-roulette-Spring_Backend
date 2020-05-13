package com.rouletteonline.springboot.backend.apirest.services;

import java.util.List;

import com.rouletteonline.springboot.backend.apirest.models.entity.Bet;

public interface IBetService {

	public Bet save(Bet bet);

	public int setBetInfoByRouletteId(Long rouletteId);

	public List<Bet> findBetsByRouletteId(Long rouletteId);

}
