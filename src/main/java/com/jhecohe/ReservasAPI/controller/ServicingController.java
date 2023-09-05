package com.jhecohe.ReservasAPI.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhecohe.ReservasAPI.service.ServicingService;
import com.jhecohe.ReservasAPI.service.dto.ServicingDTO;

import lombok.AllArgsConstructor;

@RequestMapping("/api")
@RestController
@AllArgsConstructor
public class ServicingController {

ServicingService servicinService;
	
	@PostMapping("/service")
	public ResponseEntity<ServicingDTO> createServicing(@RequestBody ServicingDTO servicing) {
		ServicingDTO servicingDTO = servicinService.createServicing(servicing);
		return new ResponseEntity<>(servicingDTO, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/services/{tradingId}")
	public ResponseEntity<List<ServicingDTO>> servicingListByTrading(@PathVariable Long tradingId) {
		List<ServicingDTO> servicingDTOList = servicinService.getServicingByTradingId(tradingId);
		return new ResponseEntity<>(servicingDTOList, HttpStatus.OK);
	}
}
