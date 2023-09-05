package com.jhecohe.ReservasAPI.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jhecohe.ReservasAPI.exceptions.ServiceException;
import com.jhecohe.ReservasAPI.mapper.TradingMapper;
import com.jhecohe.ReservasAPI.persistence.entity.Trading;
import com.jhecohe.ReservasAPI.persistence.repository.TradingRepository;
import com.jhecohe.ReservasAPI.service.dto.TradingDTO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TradingService {

	private final TradingRepository tradingRepository;
	private final TradingMapper tradingMapper;
	
	public TradingDTO createTrading(TradingDTO trading) {
		Trading t = tradingMapper.getEntity(trading);
		Trading tSaved = tradingRepository.save(t);
		return tradingMapper.getDTO(tSaved);
	}

	public Trading getTrading(long servicingId) {
		// TODO Auto-generated method stub
		Optional<Trading> trading = tradingRepository.findById(servicingId);
		if(trading.isEmpty())
		{
			throw new ServiceException("Trading ID not found", HttpStatus.NOT_FOUND);
		}
		return trading.get();
	}

	public List<TradingDTO> getTradingList() {
		// TODO Auto-generated method stub
		List<Trading> tradingList = tradingRepository.findAll();
		List<TradingDTO> dtoList = tradingList.stream().map(trading -> tradingMapper.getDTO(trading))
		.collect(Collectors.toList());
		return dtoList;
	}
}
