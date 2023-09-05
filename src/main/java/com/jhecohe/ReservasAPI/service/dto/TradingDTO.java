package com.jhecohe.ReservasAPI.service.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@Valid
public class TradingDTO {
	private Long id;
	@NotNull
	private String name;
	@NotNull
	private int maxCapacity;
}
