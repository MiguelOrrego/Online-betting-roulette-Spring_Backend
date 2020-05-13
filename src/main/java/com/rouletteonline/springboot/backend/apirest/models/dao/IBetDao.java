package com.rouletteonline.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.rouletteonline.springboot.backend.apirest.models.entity.Bet;

public interface IBetDao extends JpaRepository<Bet, Long> {

	@Modifying(clearAutomatically = true)
	@Query("UPDATE Bet b SET b.state='Cerrada' WHERE b.roulette.id=?1 AND b.state='Activa' ")
	public int setBetInfoByRouletteId(Long id);

	public List<Bet> findByRouletteId(Long rouletteId);

}
