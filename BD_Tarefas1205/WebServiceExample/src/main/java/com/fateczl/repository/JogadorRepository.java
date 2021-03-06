package com.fateczl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fateczl.model.entity.Jogador;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Integer> {

	
	List<Jogador> findJogadoresDataConv();
	Jogador findJogadorDataConv(int cod);
}
