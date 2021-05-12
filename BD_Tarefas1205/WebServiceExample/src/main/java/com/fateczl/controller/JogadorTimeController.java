package com.fateczl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fateczl.model.dto.JogadorDTO;
import com.fateczl.model.dto.TimesDTO;
import com.fateczl.model.entity.JogadorTime;
import com.fateczl.repository.JogadorTimeRepositroy;

@RestController
@RequestMapping("/api")
public class JogadorTimeController {

	@Autowired
	private JogadorTimeRepositroy jtRep;
	
	
	@GetMapping("/jogador/idade/{codigo}")
	public ResponseEntity<JogadorDTO> getJogadorIdade(@PathVariable("codigo") int codigo) {
		JogadorTime j = jtRep.udfJogadorIdade(codigo);
		JogadorDTO jDTO = converterJogadorTime(j);
		return ResponseEntity.ok(jDTO);
	}


	private JogadorDTO converterJogadorTime(JogadorTime j) {
		JogadorDTO jDTO = new JogadorDTO();
    	jDTO.setCodigo(j.getCodigo());
    	jDTO.setNomeJogador(j.getNomeJogador());
    	jDTO.setSexo(j.getSexo());
    	jDTO.setAltura(j.getAltura());
    	jDTO.setDt_nasc(j.getDt_nasc());
    	jDTO.setIdade(j.getIdade());
    	
    	TimesDTO tDTO = new TimesDTO();
    	tDTO.setId(Integer.parseInt(j.getId()));
    	tDTO.setNome(j.getNome());
    	tDTO.setCidade(j.getCidade());
    	
    	jDTO.setTimes(tDTO);
		return jDTO;
	}
}
