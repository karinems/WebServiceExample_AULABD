package com.fateczl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fateczl.model.entity.Times;

@Repository
public interface TimesRepository extends JpaRepository<Times, Integer> {

	@Procedure(name = "Times.spCrudTimes")
	String spCrudTimes(@Param("cod") String cod, @Param("id") int id, @Param("nome") String nome, @Param("cidade") String cidade);
}
