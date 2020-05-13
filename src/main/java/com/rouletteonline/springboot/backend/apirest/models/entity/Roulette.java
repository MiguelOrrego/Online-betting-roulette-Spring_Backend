package com.rouletteonline.springboot.backend.apirest.models.entity;

import java.io.*;
import javax.persistence.*;

@Entity
@Table(name = "roulette")
public class Roulette implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
