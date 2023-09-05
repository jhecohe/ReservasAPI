package com.jhecohe.ReservasAPI.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.jhecohe.ReservasAPI.service.ServicingService;
import com.jhecohe.ReservasAPI.service.dto.ServicingDTO;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(ServicingController.class)
public class ServicingControllerTest {
	
	@MockBean
	ServicingService servicingService;
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	void createServicing() throws Exception {
		ServicingDTO tDTO = mockServicingDTO();
		when(servicingService.createServicing(any(ServicingDTO.class)))
		.thenReturn(tDTO);
		this.mockMvc.perform(post("/api/service")
				.accept(MediaType.APPLICATION_JSON)
				.content("{\r\n"
						+ "  \"name\": \"Polichado\",\r\n"
						+ "  \"serviceDate\": \"04/10/2023\",\r\n"
						+ "  \"open\": \"08:00\",\r\n"
						+ "  \"close\": \"18:00\",\r\n"
						+ "  \"duration\": 60,\r\n"
						+ "  \"tradingId\": 1\r\n"
						+ "}")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isCreated());
	}
	
	@Test
	void listServicingByTrading() throws Exception {
		ServicingDTO tDTO = mockServicingDTO();
		List<ServicingDTO> servicingList = new ArrayList<>();
		servicingList.add(tDTO);
		when(servicingService.getServicingByTradingId(1L))
		.thenReturn(servicingList);
		this.mockMvc.perform(get("/api/services/{tradingId}", 1L))
		.andDo(print())
		.andExpect(status().isOk());
	}
	
	private ServicingDTO mockServicingDTO() {
		return new ServicingDTO("Lavado General", 
				LocalDate.now().toString(), 
				"07:00", 
				"18:00", 
				60L,
				1L);
	}
}
