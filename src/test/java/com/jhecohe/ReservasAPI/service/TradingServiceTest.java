package com.jhecohe.ReservasAPI.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jhecohe.ReservasAPI.mapper.TradingMapper;
import com.jhecohe.ReservasAPI.persistence.entity.Trading;
import com.jhecohe.ReservasAPI.persistence.repository.TradingRepository;
import com.jhecohe.ReservasAPI.service.dto.TradingDTO;

@ExtendWith(MockitoExtension.class)
public class TradingServiceTest {

	@InjectMocks
	TradingService tradingService;
	
	@InjectMocks
	TradingMapper tradingMapper;
	
	@Mock
	TradingMapper tradingMapperMock;
	
	@Mock
	TradingRepository tradingRepository;
	
	@Test
	void createTrading() {
		Trading mockTrading = mockTrading();
		TradingDTO mockTradingDTO = tradingMapper.getDTO(mockTrading);
		Mockito.when(tradingRepository.save(any(Trading.class)))
		.thenReturn(mockTrading);
		Mockito.when(tradingMapperMock.getDTO(any(Trading.class)))
		.thenReturn(mockTradingDTO);
		Mockito.when(tradingMapperMock.getEntity(any(TradingDTO.class)))
		.thenReturn(mockTrading);
		TradingDTO tDTO = tradingService.createTrading(mockTradingDTO);
		assertNotNull(tDTO);
		assertEquals("Car Center", tDTO.getName());
	}
	
	@Test
	void getTrading() {
		Trading mockTrading = mockTrading();
		Mockito.when(tradingRepository.findById(1L))
		.thenReturn(Optional.of(mockTrading));
		Trading t = tradingService.getTrading(1L);
		assertNotNull(t);
		assertEquals("Car Center", t.getName());
	}
	
	private Trading mockTrading() {
//		List<Servicing> serviceList = new ArrayList<Servicing>();
		return new Trading("Car Center",6);
	}
}
