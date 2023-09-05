package com.jhecohe.ReservasAPI.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhecohe.ReservasAPI.service.TurnService;
import com.jhecohe.ReservasAPI.service.dto.TurnDTO;
import com.jhecohe.ReservasAPI.service.dto.TurnProcedureDTO;
import com.jhecohe.ReservasAPI.service.dto.TurnUpdateDTO;

import lombok.AllArgsConstructor;

@RequestMapping("/api")
@RestController
@AllArgsConstructor
public class TurnController {

TurnService turnService;
	
	@PostMapping("/turnGenarete")
	public ResponseEntity<HttpStatus> createServicing(@RequestBody TurnProcedureDTO procedureDTO) {
		turnService.createTurns(procedureDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	@GetMapping("/turns/{servicingId}")
	public ResponseEntity<List<TurnDTO>> servicingListByTrading(@PathVariable Long servicingId) {
		List<TurnDTO> servicingDTOList = turnService.getTurnsByServicingId(servicingId);
		return new ResponseEntity<>(servicingDTOList, HttpStatus.OK);
	}
	
	@PatchMapping("turn/{turnId}")
	public ResponseEntity<TurnDTO> updateStateTurn(@PathVariable Long turnId, 
			@RequestBody TurnUpdateDTO updateDTO){
		TurnDTO turnDTO = turnService.updateStateTurn(turnId, updateDTO);
		return new ResponseEntity<>(turnDTO, HttpStatus.OK);
	}
}
