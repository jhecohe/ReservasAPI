/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jhecohe.ReservasAPI.persistence.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 *
 * @author jhecohe
 */
public class TradingTest {
    
	@Test
	void validateCustomer() {
		Trading cus = new Trading("Car Center", 5);
		assertEquals("Car Center", cus.getName());
		assertEquals(5, cus.getMaxCapacity());
	}
}
