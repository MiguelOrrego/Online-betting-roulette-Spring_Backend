package com.rouletteonline.springboot.backend.apirest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rouletteonline.springboot.backend.apirest.models.dao.IUserDao;
import com.rouletteonline.springboot.backend.apirest.models.entity.User;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Override
	public User findUserById(Long id) {
		// TODO Auto-generated method stub
		return userDao.findById(id).orElse(null);
	}

}
