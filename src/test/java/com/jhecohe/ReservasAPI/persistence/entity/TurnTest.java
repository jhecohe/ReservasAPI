/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jhecohe.ReservasAPI.persistence.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

/**
 *
 * @author jhecohe
 */
public class TurnTest {
    
	@Test
	void validateService() {
		Servicing serving = new Servicing("Lavado General", 
				LocalDate.now(), 
				LocalTime.of(07,00), 
				LocalTime.of(18, 00), 
				60L,
				new Trading("Car Center", 5));
		
		Turn turn = new Turn(LocalDate.now(), 
				LocalTime.of(07,00), 
				LocalTime.of(8,00),
				TurnStatus.FREE,
				serving);
		
		assertThat(turn.getTurnDate()).isAfter(LocalDate.now().minusDays(1));
		assertThat(turn.getStartDate()).isEqualTo(LocalTime.of(07,00));
		assertThat(turn.getEndDate()).isEqualTo(LocalTime.of(8,00));
		assertEquals(turn.getTurnStatus(), TurnStatus.FREE);
	}
}
