package com.gavril.springmvcjparest02.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gavril.springmvcjparest02.model.People;

public interface MyRepoI extends JpaRepository<People, Integer> {

	
}
