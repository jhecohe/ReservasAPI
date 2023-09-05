package com.jhecohe.ReservasAPI.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhecohe.ReservasAPI.service.TradingService;
import com.jhecohe.ReservasAPI.service.dto.TradingDTO;

import lombok.AllArgsConstructor;

@RequestMapping("/api")
@RestController
@AllArgsConstructor
public class TradingController {

	TradingService tradingService;
	
	@PostMapping("/trading")
	public ResponseEntity<TradingDTO> createTrading(@RequestBody TradingDTO trading) {
		TradingDTO tradingDTO = tradingService.createTrading(trading);
		return new ResponseEntity<>(tradingDTO, HttpStatus.CREATED);
	}
	
	@GetMapping("/trading")
	public ResponseEntity<List<TradingDTO>> getTradingList() {
		List<TradingDTO> tradingDTOList = tradingService.getTradingList();
		return new ResponseEntity<>(tradingDTOList, HttpStatus.OK);
	}
}
