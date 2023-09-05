package com.jhecohe.ReservasAPI.persistence.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

public class ServicingTest {

	@Test
	void validateService() {
		Servicing ser = new Servicing("Lavado General", 
				LocalDate.now(), 
				LocalTime.of(07,00), 
				LocalTime.of(18, 00), 
				60L,
				new Trading("Car Center", 5));
		
		assertEquals("Lavado General", ser.getName());
		assertThat(ser.getServiceDate()).isAfter(LocalDate.now().minusDays(1));
		assertThat(ser.getOpen()).isEqualTo(LocalTime.of(07,00));
		assertThat(ser.getClose()).isEqualTo(LocalTime.of(18,00));
		assertEquals(60, ser.getDuration());
		assertNotNull(ser.getTrading().getName());
	}
}
