package com.rouletteonline.springboot.backend.apirest.services;

import java.util.List;

import com.rouletteonline.springboot.backend.apirest.models.entity.Roulette;

public interface IRouletteService {

	public Roulette save(Roulette roulette);

	public List<Roulette> finAll();

	public Roulette findById(Long id);

}
