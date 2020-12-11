package com.gavril.springmvcjparest02.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gavril.springmvcjparest02.model.Person;

public interface MyRepoI extends JpaRepository<Person, Integer> {

	List<Person> getPersonByName(String name);
	
	@Query("from Person where tech= :tech")
	List<Person> updateTechField(@Param("tech") String tech);
}
