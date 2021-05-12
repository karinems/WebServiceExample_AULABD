package com.fateczl.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fateczl.model.dto.JogadorDTO;
import com.fateczl.model.dto.TimesDTO;
import com.fateczl.model.entity.Jogador;
import com.fateczl.repository.JogadorRepository;

@RestController
@RequestMapping("/api")
public class JogadorController {

	@Autowired
	private JogadorRepository jRep;
	
	@GetMapping("/jogador")
	public List<JogadorDTO> getAllJogador(){
		List<Jogador> listaJogador = jRep.findJogadoresDataConv();
		List<JogadorDTO> listaJogadorDTO = converterListaJogador(listaJogador);
		return listaJogadorDTO;
	}
	
	@GetMapping("/jogador/{codigo}")
	public ResponseEntity<JogadorDTO> getJogador(@PathVariable("codigo") int codigo){
		Jogador j = jRep.findJogadorDataConv(codigo);
		JogadorDTO jDTO = converterJogador(j);
		return ResponseEntity.ok(jDTO);
	}
	
	@PostMapping("/jogador")
	public ResponseEntity<String> insertJogador(@Valid @RequestBody Jogador j){
		jRep.save(j);
		return ResponseEntity.ok("Jogador inserido com sucesso");
	}
	
	@PutMapping("/jogador/{codigo}")
	public ResponseEntity<String> updateJogador(@Valid @RequestBody Jogador j){
		jRep.save(j);
		return ResponseEntity.ok("Jogador atualizado com sucesso");
	}

	@DeleteMapping("/jogador/{codigo}")
	public ResponseEntity<String> deleteJogador(@Valid @RequestBody Jogador j){
		jRep.delete(j);
		return ResponseEntity.ok("Jogador deletado com sucesso");

	}
	private JogadorDTO converterJogador(Jogador j) {
		JogadorDTO jDTO = new JogadorDTO();
    	jDTO.setCodigo(j.getCodigo());
    	jDTO.setNomeJogador(j.getNomeJogador());
    	jDTO.setSexo(j.getSexo());
    	jDTO.setAltura(j.getAltura());
    	jDTO.setDt_nasc(j.getDt_nasc());
    	
    	TimesDTO tDTO = new TimesDTO();
    	tDTO.setId(j.getTimes().getId());
    	tDTO.setNome(j.getTimes().getNome());
    	tDTO.setCidade(j.getTimes().getCidade());
    	
    	jDTO.setTimes(tDTO);
    	
		return jDTO;
	}

	private List<JogadorDTO> converterListaJogador(List<Jogador> listaJogador) {
        List<JogadorDTO> listaJogadorDTO = new ArrayList<JogadorDTO>();
        for (Jogador j : listaJogador) {
        	JogadorDTO jDTO = new JogadorDTO();
        	jDTO.setCodigo(j.getCodigo());
        	jDTO.setNomeJogador(j.getNomeJogador());
        	jDTO.setSexo(j.getSexo());
        	jDTO.setAltura(j.getAltura());
        	jDTO.setDt_nasc(j.getDt_nasc());
        	
        	TimesDTO tDTO = new TimesDTO();
        	tDTO.setId(j.getTimes().getId());
        	tDTO.setNome(j.getTimes().getNome());
        	tDTO.setCidade(j.getTimes().getCidade());
        	
        	jDTO.setTimes(tDTO);
        	
        	listaJogadorDTO.add(jDTO);
        }
		return listaJogadorDTO;
	}
	
}
