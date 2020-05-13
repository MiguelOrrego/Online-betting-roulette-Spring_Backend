package com.rouletteonline.springboot.backend.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rouletteonline.springboot.backend.apirest.models.entity.User;

public interface IUserDao extends JpaRepository<User, Long> {

}
