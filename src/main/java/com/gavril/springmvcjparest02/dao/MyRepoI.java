package com.gavril.springmvcjparest02.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gavril.springmvcjparest02.model.Person;

public interface MyRepoI extends JpaRepository<Person, Integer> {

	List<Person> getPersonByName(String name);

	
}
