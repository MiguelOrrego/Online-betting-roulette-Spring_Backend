package com.rouletteonline.springboot.backend.apirest.controller;

import java.util.*;
import java.util.stream.Collectors;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rouletteonline.springboot.backend.apirest.models.entity.Bet;
import com.rouletteonline.springboot.backend.apirest.models.entity.Roulette;
import com.rouletteonline.springboot.backend.apirest.services.IBetService;
import com.rouletteonline.springboot.backend.apirest.services.IRouletteService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class RouletteRestController {

	@Autowired(required = true)
	private IRouletteService rouletteService;

	@Autowired(required = true)
	private IBetService betService;

	@GetMapping("/roulettes")
	public List<Roulette> index() {
		return rouletteService.finAll();
	}

	@PostMapping("/roulettes")
	public ResponseEntity<?> create(@Valid @RequestBody Roulette roulette, BindingResult result) {

		Roulette rouletteNew = null;

		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El Campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put("errors", errors);

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);

		}

		try {
			rouletteNew = rouletteService.save(roulette);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "la ruleta ha sido creado con éxito!");
		response.put("ruleta", rouletteNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@SuppressWarnings("unused")
	@PostMapping("/roulette/opening")
	public ResponseEntity<?> rouletteOpening(@Valid @RequestBody Roulette roulette, BindingResult result) {

		List<Bet> betsList = betService.findBetsByRouletteId(roulette.getId());
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El Campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put("errors", errors);

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);

		}

		try {

			if (betsList.size() == 0) {
				response.put("mensaje", "No se puede dar apertura a la ruleta por que no hay apuestas");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}

			for (int i = 0; i < betsList.size(); i++) {

				if (betsList.get(i).getNumber() == null) {

					if (betsList.get(i).getAmountMoney() > 10000 || betsList.get(i).getAmountMoney() < 0) {
						response.put("mensaje", "Operacion Denegada");
						return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
					} else {
						response.put("mensaje", "Operacion Exitosa");
						return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
					}
				}

				if (betsList.get(i).getNumber() < 0 || betsList.get(i).getNumber() > 36) {
					response.put("mensaje", "Operacion Denegada");

					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
				} else if (betsList.get(i).getAmountMoney() > 10000 || betsList.get(i).getAmountMoney() < 0) {
					response.put("mensaje", "Operacion Denegada");

					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
				} else {
					response.put("mensaje", "Operacion Exitosa");
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}

		} catch (

		DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}

}
