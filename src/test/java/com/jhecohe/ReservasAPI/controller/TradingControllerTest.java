package com.jhecohe.ReservasAPI.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.jhecohe.ReservasAPI.service.TradingService;
import com.jhecohe.ReservasAPI.service.dto.TradingDTO;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(TradingController.class)
public class TradingControllerTest {
	
	@MockBean
	TradingService tradingService;
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	void createTrading() throws Exception {
		TradingDTO tDTO = mockTradingDTO();
		when(tradingService.createTrading(any(TradingDTO.class)))
		.thenReturn(tDTO);
		this.mockMvc.perform(post("/api/trading")
				.accept(MediaType.APPLICATION_JSON)
				.content("{\r\n"
						+ "  \"name\": \"Car Center\",\r\n"
						+ "  \"maxCapacity\": 6\r\n"
						+ "}")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isCreated());
	}
	
	private TradingDTO mockTradingDTO() {
		return new TradingDTO(1L, "Car Center", 6);
	}
}
