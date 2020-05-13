package com.rouletteonline.springboot.backend.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rouletteonline.springboot.backend.apirest.models.entity.Roulette;

public interface IRouletteDao extends JpaRepository<Roulette, Long> {

}
