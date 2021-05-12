package com.fateczl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fateczl.model.entity.JogadorTime;

@Repository
public interface JogadorTimeRepositroy extends JpaRepository<JogadorTime, Integer>{

	JogadorTime udfJogadorIdade(int codigo);

}
 