package com.rouletteonline.springboot.backend.apirest.services;

import com.rouletteonline.springboot.backend.apirest.models.entity.User;

public interface IUserService {

	public User findUserById(Long id);
}
