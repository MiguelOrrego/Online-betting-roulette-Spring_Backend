package com.rouletteonline.springboot.backend.apirest.models.entity;

import java.io.*;
import javax.persistence.*;

@Entity
@Table(name = "roulette")
public class Roulette implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String state;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
