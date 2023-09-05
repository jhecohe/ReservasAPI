package com.jhecohe.ReservasAPI.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jhecohe.ReservasAPI.mapper.ServiceMapper;
import com.jhecohe.ReservasAPI.persistence.entity.Servicing;
import com.jhecohe.ReservasAPI.persistence.entity.Trading;
import com.jhecohe.ReservasAPI.persistence.repository.ServiceRepository;
import com.jhecohe.ReservasAPI.service.dto.ServicingDTO;

@ExtendWith(MockitoExtension.class)
public class ServicingServiceTest {

	@InjectMocks
	ServicingService servicingService;
	
	@InjectMocks
	ServiceMapper serviceMapper;
	
	@Mock
	ServiceMapper ServiceMapperMock;
	
	@Mock
	ServiceRepository serviceRepository;
	
	@Test
	void createService() {
		Servicing mockService = mockService();
		ServicingDTO mockServicingDTO = serviceMapper.getDTO(mockService);
		Mockito.when(serviceRepository.save(any(Servicing.class)))
		.thenReturn(mockService);
		Mockito.when(ServiceMapperMock.getDTO(any(Servicing.class)))
		.thenReturn(mockServicingDTO);
		Mockito.when(ServiceMapperMock.getEntity(any(ServicingDTO.class)))
		.thenReturn(mockService);
		ServicingDTO tDTO = servicingService.createServicing(mockServicingDTO);
		assertNotNull(tDTO);
		assertEquals("Lavado General", tDTO.getName());
	}
	
	private Servicing mockService() {
		return new Servicing("Lavado General", 
				LocalDate.now(), 
				LocalTime.of(07,00), 
				LocalTime.of(18, 00), 
				60L,
				new Trading("Car Center", 5));
	}
}
