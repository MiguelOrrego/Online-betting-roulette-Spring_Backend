package com.rouletteonline.springboot.backend.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rouletteonline.springboot.backend.apirest.models.entity.Roulette;
import com.rouletteonline.springboot.backend.apirest.services.IRouletteService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class RouletteRestController {

	@Autowired(required = true)
	private IRouletteService rouletteService;

	@GetMapping("/roulettes")
	public List<Roulette> index() {
		return rouletteService.finAll();
	}

}
